package com.mail.elmaalmi.billal.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static Connection connection;
    public static Connection getConnection(){
        if (connection != null){
            return connection;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println(AppConf.DB_HOST);
            connection = DriverManager.getConnection(
                    "jdbc:mysql://"+AppConf.DB_HOST+":3306/"+AppConf.DB_NAME
                    ,AppConf.DB_USERNAME
                    ,AppConf.DB_PASSWORD);
            System.out.println("Connection Successfully to Mysql");
        }
        catch (Exception e) {
            System.out.println("Erreur de drivers JDBC : "+e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

}
