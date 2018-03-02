/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kuzmin.secret.core.dao;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;

/**
 *
 * @author Антон
 */
public class ShopDao extends NamedParameterJdbcDaoSupport {
    private static final String TABLE_NAME = "shop";
    private static final String FIELDS = "id, name";

    private static final String SELECT_SHOP_BY_ID = "select " + FIELDS + " from " + TABLE_NAME + " where id = :id";
    private static final String SELECT_SHOP

    public ShopDao(DataSource dataSource) {
        setDataSource(dataSource);
        checkDaoConfig();
    }



}
