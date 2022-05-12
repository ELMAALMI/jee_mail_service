package com.mail.elmaalmi.billal.service.imp;

import com.mail.elmaalmi.billal.dao.imp.EmailDaoImp;
import com.mail.elmaalmi.billal.model.Email;
import com.mail.elmaalmi.billal.service.EmailService;
import com.mail.elmaalmi.billal.util.SendMail;
import com.mail.elmaalmi.billal.dao.EmailDao;
import com.mail.elmaalmi.billal.model.User;

import java.util.List;

public class EmailServiceImp implements EmailService {
    private EmailDao emailDao = new EmailDaoImp();
    private SendMail sendMail = new SendMail();
    @Override
    public List<Email> findAll() {
        return null;
    }

    @Override
    public Email findOne(int id) {
        return emailDao.find(id);
    }

    @Override
    public void create(Email o, User user) {
        try {
            emailDao.save(o);
            sendMail.send(o,user);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    @Override
    public List<Email> retrieveUserEmail(String email) {
        return emailDao.find("`from`",email);
    }

    @Override
    public void create(Email e) {
    }

    @Override
    public void update(Email o) {

    }

    @Override
    public void delete(Email e) {

    }

    @Override
    public Email find(long id) {
        return null;
    }
}
