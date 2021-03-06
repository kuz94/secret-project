package ru.kuzmin.rent.equipment.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.kuzmin.rent.equipment.entities.Category;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryDao extends NamedParameterJdbcDaoSupport {

    private final RowMapper<Category> categoryRowMapper =
            (rs, i) -> new Category(rs.getLong("id"), rs.getString("name"), rs.getLong("parentId"));

    public CategoryDao(DataSource dataSource) {
        setDataSource(dataSource);
        checkDaoConfig();
    }

    public Category insert(Category category) {
        String sql = "intert into `category`(`name`, `parent_id`) values (:name, :parentId)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("name", category.getName())
                .addValue("parentId", category.getParentId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql , parameterSource, keyHolder);
        return Category.builder()
                .withId(keyHolder.getKey().longValue())
                .withName(category.getName())
                .withParentId(category.getParentId())
                .build();
    }

    public void update(Category category) {
        String sql = "update `category` set name = :name, parent_id = :parentId where id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", category.getId())
                .addValue("name", category.getName())
                .addValue("parentId", category.getParentId());
        getNamedParameterJdbcTemplate().update(sql, parameterSource);
    }

    public void delete(Category category) {
        getNamedParameterJdbcTemplate().update(
                "remove from `category` where id = :id",
                new MapSqlParameterSource("id", category.getId()));
    }

    public Optional<Category> load(long categoryId) {
        List<Category> categories = getNamedParameterJdbcTemplate().query(
                "select * from `category` where `id` = :id",
                new MapSqlParameterSource("id", categoryId),
                categoryRowMapper);
        if (categories.size() > 1) {
            throw new RuntimeException("");
        }
        return !categories.isEmpty() ? Optional.of(categories.get(0)) : Optional.empty();
    }

    public List<Category> loadSubcategories(Category category) {
        if (category != null) {
            return getNamedParameterJdbcTemplate().query(
                    "select * from `category` where `parent_id` = :parentId",
                    new MapSqlParameterSource("parentId", category.getId()),
                    categoryRowMapper);
        } else {
            return getNamedParameterJdbcTemplate().query(
                    "select * from `category` where `parent_id` is null",
                    categoryRowMapper);
        }
    }
}
