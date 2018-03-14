/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kuzmin.secret.core.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;
import ru.kuzmin.secret.core.entity.EquipmentType;

import javax.sql.DataSource;
import java.util.List;

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

    public List<EquipmentType> findAll() {
        return null;// getNamedParameterJdbcTemplate().query(SELECT_TYPES, equipTypeMapper);
    }

    public EquipmentType findById() {
        return null;
    }
}
