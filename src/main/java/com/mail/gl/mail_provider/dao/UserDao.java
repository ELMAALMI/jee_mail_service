package com.mail.gl.mail_provider.dao;

import com.mail.gl.mail_provider.model.User;

public interface UserDao extends DataAccess<User>{
    User findUserByEmail(String email);
    User login(String email,String password);
}
