/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kuzmin.rent.equipment.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;
import ru.kuzmin.rent.equipment.entities.EquipmentAttribute;

import javax.sql.DataSource;
import java.util.List;

/**
 *
 * @author Антон
 */
@Repository
public class EquipmentAttributesDao extends NamedParameterJdbcDaoSupport {

	private final RowMapper<EquipmentAttribute> equipmentAttributeMapper = null;

    public EquipmentAttributesDao(DataSource dataSource) {
        setDataSource(dataSource);
        checkDaoConfig();
    }

    public EquipmentAttribute insert() {
        return null;
    }

    public void update() {

    }

    public void delete() {

    }

    public List<EquipmentAttribute> load() {
        return null;
    }
}
