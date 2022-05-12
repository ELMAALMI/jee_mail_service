package com.mail.gl.elmaalmi.dao;

import com.mail.gl.elmaalmi.model.Email;

import java.util.List;


public interface EmailDao extends DataAccess<Email> {
    List<Email> find(String column, String value);
}
