package com.jijo.bank.testsupport;

import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;


public class TestDataSourceFactory {

    public static DataSource create(String name) {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
//        dataSourceBuilder.url("jdbc:h2:mem:" + name);
        dataSourceBuilder.url("jdbc:h2:file:c:/tmp/data/customerdb");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
}
