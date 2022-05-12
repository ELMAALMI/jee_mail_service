package com.mail.gl.elmaalmi.dao;

import com.mail.gl.elmaalmi.model.User;

public interface UserDao extends DataAccess<User>{
    User findUserByEmail(String email);
    User login(String email,String password);
    void changeUserStatus(long id,boolean active);
}
