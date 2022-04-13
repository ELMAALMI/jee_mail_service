package com.mail.gl.mail_provider.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    private static Connection connection;
    private final static String DB_USER = "root";
    private final static String DB_PWD = "123456789";
    private final static String DB_NAME="fmail_db";
    private final static String DB_HOST="localhost";
    /*
    public static Connection getConnection(){
        try {
            Context ctx = new InitialContext();
            if(ctx == null )
                throw new Exception("Boom - No Context");
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mailDB");
            if(ds != null){
                connection = ds.getConnection();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }*/

    public static Connection getConnection(){
        if (connection != null){
            return connection;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://"+DB_HOST+":3306/"+DB_NAME,DB_USER,DB_PWD);
            System.out.println("Connection Successfully to Mysql");
        }
        catch (Exception e) {
            System.out.println("Erreur de drivers JDBC : "+e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

}
