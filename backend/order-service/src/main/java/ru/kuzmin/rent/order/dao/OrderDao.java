/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kuzmin.rent.order.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.kuzmin.rent.order.entities.Order;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Антон
 */
@Repository
public class OrderDao extends NamedParameterJdbcDaoSupport {

    private final RowMapper<Order> orderMapper = (rs, i) -> Order.builder()
            .withId(rs.getLong("id"))
            .withShopId(rs.getLong("shop_id"))
            .withUserId(rs.getLong("user_id"))
            .withEquipmentId(rs.getLong("equip_id"))
            .build();

    public OrderDao(DataSource dataSource) {
        setDataSource(dataSource);
        checkDaoConfig();
    }

    public Order insert(Order order) {
        String sql = "intert into `order`(`shop_id`, `user_id`, `equip_id`, `start`) values (:shopId, :userId, :equipmentId, :startTime)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", order.getId())
                .addValue("shopId", order.getShopId())
                .addValue("userId", order.getUserId())
                .addValue("equipmentId", order.getEquipmentId())
                .addValue("startTime", order.getStartTime());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql , parameterSource, keyHolder);
        return Order.builder()
                .withId(keyHolder.getKey().longValue())
                .withShopId(order.getShopId())
                .withUserId(order.getUserId())
                .withEquipmentId(order.getEquipmentId())
                .withStartTime(order.getStartTime())
                .build();
    }

    public void update(Order order) {
        String sql = "update `order` set shop_id = :shopId, user_id = :userId, equip_id = :equipmentId, start = :startTime where id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", order.getId())
                .addValue("shopId", order.getShopId())
                .addValue("userId", order.getUserId())
                .addValue("equipmentId", order.getEquipmentId())
                .addValue("startTime", order.getStartTime());
        getNamedParameterJdbcTemplate().update(sql, parameterSource);
    }

    public void delete(Order category) {
        getNamedParameterJdbcTemplate().update(
                "remove from `category` where id = :id",
                new MapSqlParameterSource("id", category.getId()));
    }

    public Optional<Order> load(long orderId) {
        List<Order> categories = getNamedParameterJdbcTemplate().query(
                "select * from `order` where `id` = :id",
                new MapSqlParameterSource("id", orderId),
                orderMapper);
        if (categories.size() > 1) {
            throw new RuntimeException("");
        }
        return !categories.isEmpty() ? Optional.of(categories.get(0)) : Optional.empty();
    }
}
