/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kuzmin.secret.core.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;

/**
 *
 * @author Антон
 */
public class EquipAttributesDao extends JdbcDaoSupport {
	public static final String SELECT_ATTRIBUTES = "";

    public EquipAttributesDao(DataSource dataSource) {
        setDataSource(dataSource);
        checkDaoConfig();
    }
}
