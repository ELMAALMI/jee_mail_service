package com.mail.gl.mail_provider.service.imp;

import com.mail.gl.mail_provider.dao.DataAccess;
import com.mail.gl.mail_provider.dao.UserDao;
import com.mail.gl.mail_provider.model.User;
import com.mail.gl.mail_provider.service.CrudService;

public class UserServiceImp implements CrudService<User> {
    private DataAccess<User> userDataAccess = new UserDao();
    @Override
    public void create(User o) {
        userDataAccess.save(o);
    }

    @Override
    public void update(User o) {

    }

    @Override
    public void delete(User o) {

    }

    @Override
    public User find(long id) {
        return null;
    }
}
