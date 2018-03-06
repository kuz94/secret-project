package ru.kuzmin.secret.core.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.kuzmin.secret.core.entity.Category;

import javax.sql.DataSource;
import java.util.List;

@Component
public class CategoryDao extends NamedParameterJdbcDaoSupport {

    private RowMapper<Category> categoryRowMapper =
            (rs, i) -> new Category(rs.getLong("id"), rs.getString("name"));

    public CategoryDao(DataSource dataSource) {
        setDataSource(dataSource);
        checkDaoConfig();
    }

    public Category insert(Category category) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(
                "intert into `category` values (:name)",
                new MapSqlParameterSource("name", category.getName()),
                keyHolder);
        category.setId(keyHolder.getKey().longValue());
        return category;
    }

    public void update(Category category) {
        String sql = "update `category` set name = :name where id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", category.getId())
                .addValue("name", category.getName());
        getNamedParameterJdbcTemplate().update(sql, parameterSource);
    }

    public void delete(Category category) {
        getNamedParameterJdbcTemplate().update(
                "remove from `category` where id = :id",
                new MapSqlParameterSource("id", category.getId()));
    }

    public Category loadById(long categoryId) {
        List<Category> categories = getNamedParameterJdbcTemplate().query(
                "select * from `category` where `id` = :categoryId",
                new MapSqlParameterSource("id", categoryId),
                categoryRowMapper);
        if (categories.size() == 1) {
            return categories.get(0);
        } else {
            throw new RuntimeException("");
        }
    }

    public List<Category> loadCategoryContent(Category category) {
        String sql = "select c.* " +
                "from `category_tree` ct join `category` c on ct.`subcategory_id = `c.`id` " +
                "where `category_id` = :categoryId";
        return getNamedParameterJdbcTemplate().query(sql,
                new MapSqlParameterSource("id", category.getId()),
                categoryRowMapper);
    }

    public void insertSubcategory(long categoryId, long subcategoryId) {
        String sql = "insert into `category_tree`(`category_id`, `subcategory_id`) values(:categoryId, :subcategoryId)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("category_id", categoryId)
                .addValue("subcategory_id", subcategoryId);
        getNamedParameterJdbcTemplate().update(sql, parameterSource);
    }

    public void removeSubcategory(long categoryId, long subcategoryId) {
        String sql = "delete from `category_tree` where `category_id` = :categoryId and `subcategory_id` = :subcategoryId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("category_id", categoryId)
                .addValue("subcategory_id", subcategoryId);
        getNamedParameterJdbcTemplate().update(sql, parameterSource);
    }
}
