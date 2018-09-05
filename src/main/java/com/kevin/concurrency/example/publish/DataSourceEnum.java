package com.kevin.concurrency.example.publish;

/**
 * Created by Kevin on 2018/8/24.
 */
public enum DataSourceEnum {
    DATASOURCE;
    private DBConnection connection = null;

    private DataSourceEnum() {
        connection = new DBConnection();
    }

    public DBConnection getConnection() {
        return connection;
    }
}
