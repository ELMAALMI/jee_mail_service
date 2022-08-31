package com.mail.elmaalmi.billal.dao;


import com.mail.elmaalmi.billal.config.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public interface DataAccess <T>{
    Connection connection = DbConnection.getConnection();
    void save(T o);
    void update(T o);
    void delete(T o);
    List<T> findAll();
    T find(long id);
    default void aff(){

    }
    default ResultSet findBy(String column,String value,String table,String ...sort){
        try{
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM "+table+" WHERE "+column+"='"+value+"' "+sort[0];
            System.out.println("findBy");
            return statement.executeQuery(sql);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    };

}
