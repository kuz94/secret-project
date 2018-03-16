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
import ru.kuzmin.secret.core.entity.EquipmentType;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Антон
 */
@Repository
public class EquipmentTypeDao extends NamedParameterJdbcDaoSupport {

    private final RowMapper<EquipmentType> equipTypeMapper =
            (rs, i) -> new EquipmentType(rs.getLong("id"), rs.getString("name"), rs.getLong("categoryId"));

    public EquipmentTypeDao(DataSource dataSource) {
        setDataSource(dataSource);
        checkDaoConfig();
    }

    public EquipmentType insert(EquipmentType equipmentType) {
        String sql = "insert into `equip_type`(`name`, `category_id`) values(:name, :categoryId)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("name", equipmentType.getName())
                .addValue("categoryId", equipmentType.getCategoryId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql, parameterSource, keyHolder);
        return EquipmentType.builder()
                .withId(keyHolder.getKey().longValue())
                .withName(equipmentType.getName())
                .withCategoryId(equipmentType.getCategoryId())
                .build();
    }

    public void update(EquipmentType equipmentType) {
        String sql = "update `equip_type` set name = :name, category_id = :categoryId where id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", equipmentType.getId())
                .addValue("name", equipmentType.getName())
                .addValue("categoryId", equipmentType.getCategoryId());
        getNamedParameterJdbcTemplate().update(sql, parameterSource);
    }

    public void delete(EquipmentType equipmentType) {
        getNamedParameterJdbcTemplate().update(
                "remove from `equip_type` where id = :id",
                new MapSqlParameterSource("id", equipmentType.getId()));
    }

    public Optional<EquipmentType> load(Long equipmentTypeId) {
        List<EquipmentType> types = getNamedParameterJdbcTemplate().query(
                "select * from `equip_type` where `id` = :id",
                new MapSqlParameterSource("id", equipmentTypeId),
                equipTypeMapper);
        if (types.size() > 1) {
            throw new RuntimeException("");
        }
        return !types.isEmpty() ? Optional.of(types.get(0)) : Optional.empty();
    }
}
