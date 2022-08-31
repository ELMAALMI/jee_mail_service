package com.mail.elmaalmi.billal.dao.imp;

import com.mail.elmaalmi.billal.dao.UserDao;
import com.mail.elmaalmi.billal.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    private PreparedStatement statement;

    @Override
    public void save(User o) {
        try {
            String sql = "INSERT INTO users(nom,prenom,email,password,active,birthday) VALUES (?,?,?,ENCRYPT(?,'dovecot'),?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,o.getNom());
            statement.setString(2,o.getPrenom());
            statement.setString(3,o.getEmail());
            statement.setString(4,o.getPassword());
            statement.setBoolean(5,o.isActive());
            statement.setDate(6, new Date(o.getBirthday().getTime()));
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(User o) {
        try {
            String sql = "UPDATE users SET nom=?,prenom=?,birthday=? WHERE email=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,o.getNom());
            statement.setString(2,o.getPrenom());
            statement.setDate(3, new Date(o.getBirthday().getTime()));
            statement.setString(4,o.getEmail());
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User o) {
        try {
            String sql = "DELTE FROM users WHERE email=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,o.getEmail());
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            statement = connection.prepareStatement("SELECT * FROM users");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                users.add(createObjet(set));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User find(long id) {
        return null;
    }


    @Override
    public User findUserByEmail(String email){
        try{
            String sql = "SELECT * FROM users WHERE email=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,email);
            ResultSet set = statement.executeQuery();
            if(set.next()){
               return createObjet(set);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public User login(String email, String password) {
        try{
            String sql = "SELECT * FROM users WHERE email=? AND `password`=ENCRYPT(?,'dovecot') AND active=true";
            statement = connection.prepareStatement(sql);
            statement.setString(1,email);
            statement.setString(2,password);
            ResultSet set = statement.executeQuery();
            if(set.next()){
                return createObjet(set);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void changeUserStatus(long id,boolean active){
        try {
            String sql = "UPDATE users SET active=? WHERE id=?";
            statement = connection.prepareStatement(sql);
            statement.setBoolean(1,active);
            statement.setLong(2,id);
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private User createObjet(ResultSet set) throws SQLException {
        User u = new User();
        u.setId(set.getInt("id"));
        u.setEmail(set.getString("email"));
        u.setNom(set.getString("nom"));
        u.setPrenom(set.getString("prenom"));
        u.setPassword(set.getString("password"));
        u.setBirthday(set.getDate("birthday"));
        u.setActive(set.getBoolean("active"));
        u.setAdmin(set.getBoolean("is_admin"));
        return u;
    }
}


