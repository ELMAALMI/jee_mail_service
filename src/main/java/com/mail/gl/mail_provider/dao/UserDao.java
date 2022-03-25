package com.mail.gl.mail_provider.dao;

import com.mail.gl.mail_provider.model.User;

import java.sql.PreparedStatement;
import java.util.List;

public class UserDao implements DataAccess<User>{
    @Override
    public void save(User o) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users VALUES (null ,?,?,?,?)");
            statement.setString(1,o.getNom());
            statement.setString(2,o.getPrenom());
            statement.setString(3,o.getEmail());
            statement.setString(4,o.getPassword());
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(User o) {

    }

    @Override
    public void delete(User o) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User find(long id) {
        return null;
    }
}
