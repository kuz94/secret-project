/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kuzmin.secret.core.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;
import ru.kuzmin.secret.core.entity.EquipmentAttribute;

import javax.sql.DataSource;

/**
 *
 * @author Антон
 */
@Repository
public class EquipmentAttributesDao extends NamedParameterJdbcDaoSupport {
	public static final String SELECT_ATTRIBUTES = "";

	private final RowMapper<EquipmentAttribute> equipmentAttributeMapper = null;

    public EquipmentAttributesDao(DataSource dataSource) {
        setDataSource(dataSource);
        checkDaoConfig();
    }
}
