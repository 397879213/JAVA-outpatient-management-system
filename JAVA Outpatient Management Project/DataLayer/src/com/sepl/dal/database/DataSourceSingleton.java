/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sepl.dal.database;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javax.sql.DataSource;

/**
 *
 * @author Vilcha
 */
public class DataSourceSingleton {
       
    private static final String url ="jdbc:sqlserver://LAPTOP-43901PDA\\SQLEXPRESS;databaseName=ProjectJava;integratedSecurity=true";

    private DataSourceSingleton() {}

    private static DataSource instance;

    public static DataSource getInstance() {
        if (instance == null) {
            instance = createInstance();
        }
        return instance;
    }
    private static DataSource createInstance() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setURL(url);
        return dataSource;
    }   
}
