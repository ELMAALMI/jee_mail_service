package com.mail.elmaalmi.billal.dao;

import com.mail.elmaalmi.billal.model.Email;

import java.util.List;


public interface EmailDao extends DataAccess<Email> {
    List<Email> find(String column, String value);
}
