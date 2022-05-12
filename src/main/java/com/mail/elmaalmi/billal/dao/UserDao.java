package com.mail.elmaalmi.billal.dao;

import com.mail.elmaalmi.billal.model.User;

public interface UserDao extends DataAccess<User>{
    User findUserByEmail(String email);
    User login(String email,String password);
    void changeUserStatus(long id,boolean active);
}
