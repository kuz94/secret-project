/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kuzmin.secret.core.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.kuzmin.secret.core.entity.User;

import javax.sql.DataSource;
import java.util.List;

/**
 *
 * @author Антон
 */
public class UserDao extends NamedParameterJdbcDaoSupport {

    private RowMapper<User> userRowMapper =
            (rs, i) -> new User(rs.getLong("id"), rs.getString("name"));

    public UserDao(DataSource dataSource) {
        setDataSource(dataSource);
        checkDaoConfig();
    }

    public User insert(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(
                "intert into `category` values (:name)",
                new MapSqlParameterSource("name", user.getName()),
                keyHolder);
        user.setId(keyHolder.getKey().longValue());
        return user;
    }

    public void update(User user) {
        String sql = "update `category` set name = :name where id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", user.getId())
                .addValue("name", user.getName());
        getNamedParameterJdbcTemplate().update(sql, parameterSource);
    }

    public void delete(User user) {
        getNamedParameterJdbcTemplate().update(
                "remove from `category` where id = :id",
                new MapSqlParameterSource("id", user.getId()));
    }

    public User loadById(long categoryId) {
        List<User> users = getNamedParameterJdbcTemplate().query(
                "select * from `category` where `id` = :categoryId",
                new MapSqlParameterSource("id", categoryId),
                userRowMapper);
        if (users.size() == 1) {
            return users.get(0);
        } else {
            throw new RuntimeException("");
        }
    }
}
