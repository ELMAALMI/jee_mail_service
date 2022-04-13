package com.mail.gl.mail_provider.dao;


import com.mail.gl.mail_provider.config.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DataAccess <T>{
    Connection connection = DbConnection.getConnection();
    void save(T o);
    void update(T o);
    void delete(T o);
    List<T> findAll();
    T find(long id);
    T findBy(String column,String value) throws SQLException;

}
