package com.mail.gl.elmaalmi.dao.imp;

import com.mail.gl.elmaalmi.dao.DomainDao;
import com.mail.gl.elmaalmi.model.Domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DomainDaoImp implements DomainDao {
    private PreparedStatement statement;
    private ResultSet set;
    @Override
    public void save(Domain o) {
        try {
            statement = connection.prepareStatement("INSERT INTO `domain` (name,active) VALUES(?,?)");
            statement.setString(1,o.getNom());
            statement.setBoolean(2,o.isActive());
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Domain o) {
        try {
            statement = connection.prepareStatement("UPDATE `domains` set name=?,active=? WHERE id=?");
            statement.setString(1,o.getNom());
            statement.setBoolean(2, o.isActive());
            statement.setInt(3,o.getId());
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Domain o) {

    }

    @Override
    public List<Domain> findAll() {
        return null;
    }

    @Override
    public Domain find(long id) {
        return null;
    }
}
