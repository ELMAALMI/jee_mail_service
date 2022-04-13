package com.mail.gl.mail_provider.service;

import com.mail.gl.mail_provider.model.User;

import java.util.List;

public interface UserService {
    void create(User user);
    void update(User user);
    void delete(User user);
    List<User> findAll();
}
