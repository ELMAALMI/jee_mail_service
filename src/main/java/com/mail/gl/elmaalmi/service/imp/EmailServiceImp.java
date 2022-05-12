package com.mail.gl.elmaalmi.service.imp;

import com.mail.gl.elmaalmi.dao.EmailDao;
import com.mail.gl.elmaalmi.dao.imp.EmailDaoImp;
import com.mail.gl.elmaalmi.model.Email;
import com.mail.gl.elmaalmi.model.User;
import com.mail.gl.elmaalmi.service.EmailService;
import com.mail.gl.elmaalmi.util.SendMail;

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
