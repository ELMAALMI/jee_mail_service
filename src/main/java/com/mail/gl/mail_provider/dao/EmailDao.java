package com.mail.gl.mail_provider.dao;

import com.mail.gl.mail_provider.model.Email;

import java.util.List;


public interface EmailDao extends DataAccess<Email> {
    List<Email> find(String column, String value);
}
