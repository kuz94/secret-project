package ru.kuzmin.secret.core.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.kuzmin.secret.core.entity.Category;
import ru.kuzmin.secret.core.entity.CategoryContent;

import javax.sql.DataSource;
import java.util.List;

public class CategoryDao extends NamedParameterJdbcDaoSupport {

    public CategoryDao(DataSource dataSource) {
        setDataSource(dataSource);
        checkDaoConfig();
    }

    public Category insert(Category category) {
        String sql = "intert into `category` values (:name)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(
                sql,
                new MapSqlParameterSource("name", category.getName()),
                keyHolder);
        category.setId(keyHolder.getKey().longValue());

        if (category.getParentCategoryId() != null) {
            sql = "intert into `category_content`(`category_id`, `content_id`) values(:categoryId, :contentId)";
            MapSqlParameterSource parameterSource = new MapSqlParameterSource();
            parameterSource
                    .addValue("categoryId", category.getParentCategoryId())
                    .addValue("contentId", )


            getNamedParameterJdbcTemplate().update();
        }

    }
    public void update(Category category) {

    }

    public void delete(long categoryId) {

    }

    public List<CategoryContent> loadCategoryContent(long categoryId) {

        return null;
    }

}
