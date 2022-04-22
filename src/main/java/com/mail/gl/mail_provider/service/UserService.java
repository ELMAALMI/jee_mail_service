package com.mail.gl.mail_provider.service;

import com.mail.gl.mail_provider.model.User;

import java.util.List;

public interface UserService extends CrudService<User>{
    User userLogin(User user);
    User find(String email);
}
