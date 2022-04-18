package com.mail.gl.mail_provider.service.imp;

import com.mail.gl.mail_provider.dao.EmailDao;
import com.mail.gl.mail_provider.dao.imp.EmailDaoImp;
import com.mail.gl.mail_provider.model.Email;
import com.mail.gl.mail_provider.service.EmailService;
import com.mail.gl.mail_provider.util.SendMail;

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
        return null;
    }

    @Override
    public List<Email> retrieveUserEmail(String email) {
        return emailDao.find("`from`",email);
    }

    @Override
    public void create(Email e) {
        try {
            emailDao.save(e);
            sendMail.send(e);
        }catch (Exception exception){
            exception.printStackTrace();
        }
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
