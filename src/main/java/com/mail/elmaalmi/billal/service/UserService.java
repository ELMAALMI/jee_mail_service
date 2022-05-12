package com.mail.elmaalmi.billal.service;

import com.mail.elmaalmi.billal.model.User;

public interface UserService extends CrudService<User>{
    User userLogin(User user);
    User find(String email);
    void changeUserStatus(long id,boolean active);
}
