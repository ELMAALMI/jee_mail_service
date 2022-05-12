package com.mail.gl.elmaalmi.service;

import com.mail.gl.elmaalmi.model.User;

public interface UserService extends CrudService<User>{
    User userLogin(User user);
    User find(String email);
    void changeUserStatus(long id,boolean active);
}
