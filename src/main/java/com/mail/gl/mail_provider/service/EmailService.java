package com.mail.gl.mail_provider.service;

import com.mail.gl.mail_provider.model.Email;
import com.mail.gl.mail_provider.model.User;

import java.util.List;

public interface EmailService extends CrudService<Email> {
    Email findOne(int id);

    void create(Email o, User user);

    List<Email> retrieveUserEmail(String email);
}
