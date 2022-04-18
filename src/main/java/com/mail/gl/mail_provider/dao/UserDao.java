package com.mail.gl.mail_provider.dao;

import com.mail.gl.mail_provider.model.User;

public interface UserDao extends DataAccess<User>{
    public User findUserByEmail(String email);
}
