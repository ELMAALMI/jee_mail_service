package com.mail.gl.elmaalmi.service;

import com.mail.gl.elmaalmi.model.Email;
import com.mail.gl.elmaalmi.model.User;

import java.util.List;

public interface EmailService extends CrudService<Email> {
    Email findOne(int id);

    void create(Email o, User user);

    List<Email> retrieveUserEmail(String email);
}
