package com.mail.elmaalmi.billal.service;

import com.mail.elmaalmi.billal.model.Email;
import com.mail.elmaalmi.billal.model.User;

import java.util.List;

public interface EmailService extends CrudService<Email> {
    Email findOne(int id);

    void create(Email o, User user);

    List<Email> retrieveUserEmail(String email);
}
