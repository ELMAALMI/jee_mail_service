package com.mail.gl.elmaalmi.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConf {
    public static String MAIL_HOST;
    public static String DB_HOST;
    public static String DB_PORT;
    public static String DB_NAME;
    public static String DB_USERNAME;
    public static String DB_PASSWORD;
    static {
        InputStream inputStream  = AppConf.class.getClassLoader().getResourceAsStream("/application.properties");
        Properties prop = new Properties();
        try {
            prop.load(inputStream);
            MAIL_HOST = prop.getProperty("MAIL_HOST");
            DB_HOST = prop.getProperty("DB_HOST");
            DB_PORT = prop.getProperty("DB_PORT");
            DB_NAME = prop.getProperty("DB_NAME");
            DB_USERNAME = prop.getProperty("DB_USERNAME");
            DB_PASSWORD = prop.getProperty("DB_PASSWORD");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
