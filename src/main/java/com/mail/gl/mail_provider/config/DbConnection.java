package com.mail.gl.mail_provider.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static Connection connection;
    private final static String db_user = "root";
    private final static String db_pwd = "123456789";
    private final static String db_name="db_java";

    public static Connection getConnection(){
        if (connection != null){
            return connection;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db_name,db_user,db_pwd);
            System.out.println("Connection Successfully to Mysql");
        }
        catch (Exception e) {
            System.out.println("Erreur de drivers JDBC : "+e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}
