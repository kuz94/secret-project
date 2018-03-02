/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kuzmin.secret.core.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import ru.kuzmin.secret.core.entity.EquipType;

import javax.sql.DataSource;
import java.util.List;

/**
 *
 * @author Антон
 */
public class EquipTypeDao extends NamedParameterJdbcDaoSupport {
    private static final String TABLE_NAME = "equip_type";
    private static final String FIELDS = "id, name";
    private static final String SELECT_TYPES = "select " + FIELDS + " from " + TABLE_NAME;

    private RowMapper<EquipType> equipTypeMapper = (rs, i) -> new EquipType(rs.getLong("id"), rs.getString("name"));

    public EquipTypeDao(DataSource dataSource) {
        setDataSource(dataSource);
        checkDaoConfig();
    }

    public List<EquipType> findAll() {
        return getNamedParameterJdbcTemplate().query(SELECT_TYPES, equipTypeMapper);
    }

    public EquipType findById() {
        return null;
    }

	
}
