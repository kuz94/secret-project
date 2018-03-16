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
import ru.kuzmin.secret.core.entity.Equipment;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Антон
 */
@Repository
public class EquipmentDao extends NamedParameterJdbcDaoSupport {

    private final RowMapper<Equipment> equipmentMapper =
            (rs, i) -> Equipment.builder()
                    .withId(rs.getLong("id"))
                    .withName(rs.getString("name"))
                    .withTypeId(rs.getLong("type_id"))
                    .withShopId(rs.getLong("shop_id"))
                    .build();

    public EquipmentDao(DataSource dataSource) {
        setDataSource(dataSource);
        checkDaoConfig();
    }

    public Equipment insert(Equipment equipment) {
        String sql = "insert into `equip`(`name`, `type_id`, `shop_id`) values(:name, :typeId, shopId)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("name", equipment.getName())
                .addValue("typeId", equipment.getTypeId())
                .addValue("shopId", equipment.getShopId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql, parameterSource, keyHolder);
        return Equipment.builder()
                .withId(keyHolder.getKey().longValue())
                .withName(equipment.getName())
                .withTypeId(equipment.getTypeId())
                .withShopId(equipment.getShopId())
                .build();
    }

    public void update(Equipment equipment) {
        String sql = "update `equip` set name = :name, type_id = :categoryId, shop_id = :shopId where id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", equipment.getId())
                .addValue("name", equipment.getName())
                .addValue("typeId", equipment.getTypeId())
                .addValue("shopId", equipment.getShopId());
        getNamedParameterJdbcTemplate().update(sql, parameterSource);
    }

    public void delete(Equipment equipmentType) {
        getNamedParameterJdbcTemplate().update(
                "remove from `equip` where id = :id",
                new MapSqlParameterSource("id", equipmentType.getId()));
    }

    public Optional<Equipment> load(Long equipmentId) {
        List<Equipment> equipments = getNamedParameterJdbcTemplate().query(
                "select * from `equip` where `id` = :id",
                new MapSqlParameterSource("id", equipmentId),
                equipmentMapper);
        if (equipments.size() > 1) {
            throw new RuntimeException("");
        }
        return !equipments.isEmpty() ? Optional.of(equipments.get(0)) : Optional.empty();
    }
}
