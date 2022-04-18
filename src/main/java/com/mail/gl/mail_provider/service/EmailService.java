package com.mail.gl.mail_provider.service;

import com.mail.gl.mail_provider.model.Email;

import java.util.List;

public interface EmailService extends CrudService<Email> {
    Email findOne(int id);
    List<Email> retrieveUserEmail(String email);
}
