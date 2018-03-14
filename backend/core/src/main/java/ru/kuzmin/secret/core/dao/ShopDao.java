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
import org.springframework.stereotype.Repository;
import ru.kuzmin.secret.core.entity.Shop;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Антон
 */
@Repository
public class ShopDao extends NamedParameterJdbcDaoSupport {

    private final RowMapper<Shop> shopRowMapper =
            (rs, i) -> new Shop(rs.getLong("id"), rs.getString("name"));

    public ShopDao(DataSource dataSource) {
        setDataSource(dataSource);
        checkDaoConfig();
    }

    public Shop insert(Shop shop) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(
                "intert into `category` values (:name)",
                new MapSqlParameterSource("name", shop.getName()),
                keyHolder);
        shop.setId(keyHolder.getKey().longValue());
        return shop;
    }

    public void update(Shop shop) {
        String sql = "update `category` set name = :name where id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", shop.getId())
                .addValue("name", shop.getName());
        getNamedParameterJdbcTemplate().update(sql, parameterSource);
    }

    public void delete(Shop shop) {
        getNamedParameterJdbcTemplate().update(
                "remove from `category` where id = :id",
                new MapSqlParameterSource("id", shop.getId()));
    }

    public Optional<Shop> load(long categoryId) {
        List<Shop> shops = getNamedParameterJdbcTemplate().query(
                "select * from `category` where `id` = :categoryId",
                new MapSqlParameterSource("id", categoryId),
                shopRowMapper);
        if (shops.size() > 1) {
            throw new RuntimeException("");
        }
        return !shops.isEmpty() ? Optional.of(shops.get(0)) : Optional.empty();
    }
}
