/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kuzmin.secret.core.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import javax.sql.DataSource;

/**
 *
 * @author Антон
 */
public class EquipmentAttributesDao extends NamedParameterJdbcDaoSupport {
	public static final String SELECT_ATTRIBUTES = "";

    public EquipmentAttributesDao(DataSource dataSource) {
        setDataSource(dataSource);
        checkDaoConfig();
    }
}
