/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kuzmin.secret.core.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;
import ru.kuzmin.secret.core.entity.Equipment;

import javax.sql.DataSource;

/**
 *
 * @author Антон
 */
@Repository
public class EquipmentDao extends NamedParameterJdbcDaoSupport {

    private final RowMapper<Equipment> equipmentMapper = null;

    public EquipmentDao(DataSource dataSource) {
        setDataSource(dataSource);
        checkDaoConfig();
    }

}
