package com.mail.elmaalmi.billal.dao.imp;

import com.mail.elmaalmi.billal.model.Email;
import com.mail.elmaalmi.billal.dao.EmailDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailDaoImp implements EmailDao {
    private PreparedStatement statement;
    private ResultSet set;
    @Override
    public void save(Email o) {
        try {
            statement = connection.prepareStatement("INSERT INTO inbox(`from`,`to`,subject,message,created_at) VALUES(?,?,?,?,?)");
            statement.setString(1,o.getFrom());
            statement.setString(2,o.getTo());
            statement.setString(3,o.getSubject());
            statement.setString(4,o.getMessage());
            statement.setDate(5,new Date(o.getCreatedAt().getTime()));
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Email o) {
        try {
            statement = connection.prepareStatement("UPDATE inbox set from=?,to=?,subjet=?,message=?,created_at=? WHERE id=?");
            statement.setString(1,o.getFrom());
            statement.setString(2,o.getTo());
            statement.setString(3,o.getSubject());
            statement.setString(4,o.getMessage());
            statement.setDate(5,new Date(o.getCreatedAt().getTime()));
            statement.setInt(6,o.getId());
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Email o) {
        try {
            statement = connection.prepareStatement("DELETE FROM inbox WHERE id = ?");
            statement.setInt(1,o.getId());
            statement.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Email> findAll() {
        return null;
    }

    @Override
    public Email find(long id) {
        try {
            statement = connection.prepareStatement("SELECT * FROM inbox WHERE id = ?");
            statement.setLong(1,id);
            set = statement.executeQuery();
            if(set.next()){
                return createObjet(set);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<Email> find(String column, String value) {
        List<Email> emails = new ArrayList<>();
        try {
            ResultSet set = this.findBy(column, value,"inbox","ORDER BY created_at DESC");
            while (set.next()){
                emails.add(createObjet(set));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return emails;
    }

    private Email createObjet(ResultSet set) throws SQLException {
        Email email = new Email();
        email.setId(set.getInt("id"));
        email.setSubject(set.getString("subject"));
        email.setFrom(set.getString("from"));
        email.setTo(set.getString("to"));
        email.setMessage(set.getString("message"));
        email.setCreatedAt(set.getDate("created_at"));
        return email;
    }
}
