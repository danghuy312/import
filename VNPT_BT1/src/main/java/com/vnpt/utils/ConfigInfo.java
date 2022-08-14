package com.vnpt.utils;

import java.io.File;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigInfo {

    private ConfigInfo() {
    }

    private static Config config = ConfigFactory.parseFile(new File("conf.properties"));

    public static final int TIME_AUTO = config.getInt("time.auto");

    public static final String DRIVER_NAME = config.getString("db.driver.name");
    public static final String URL = config.getString("db.url");
    public static final String USERNAME = config.getString("db.username");
    public static final String PASSWORD = config.getString("db.password");

    public static final String FILE_NAME = config.getString("filename");
}
