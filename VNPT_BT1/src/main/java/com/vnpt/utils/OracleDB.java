package com.vnpt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDB {

    private static OracleDB instance;
    private Connection connection;

    private OracleDB() {
        String DRIVER_NAME = ConfigInfo.DRIVER_NAME;
        String DB_URL = ConfigInfo.URL;
        String USER_NAME = ConfigInfo.USERNAME;
        String PASSWORD = ConfigInfo.PASSWORD;
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static OracleDB getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new OracleDB();
        }
        return instance;
    }
}
