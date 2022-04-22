package com.mail.gl.mail_provider.service.imp;

import com.mail.gl.mail_provider.dao.UserDao;
import com.mail.gl.mail_provider.dao.imp.UserDaoImp;
import com.mail.gl.mail_provider.exception.AuthException;
import com.mail.gl.mail_provider.exception.BadRequestException;
import com.mail.gl.mail_provider.model.User;
import com.mail.gl.mail_provider.service.UserService;
import com.mail.gl.mail_provider.util.BCryptPasswordEncoder;

import java.util.List;

public class UserServiceImp implements UserService {
    private final UserDao userDataAccess = new UserDaoImp();
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Override
    public void create(User o) throws Exception {
        User u = userDataAccess.findUserByEmail(o.getEmail());
        System.out.println(u);
        if(u != null){
            throw new Exception("error from service");
        }
        userDataAccess.save(o);
    }

    @Override
    public void update(User o) {
        userDataAccess.update(o);
    }

    @Override
    public void delete(User o) {
        userDataAccess.delete(o);
    }

    @Override
    public User find(long id) {
        return userDataAccess.find(id);
    }

    @Override
    public List<User> findAll() {
        return userDataAccess.findAll();
    }

    public User userLogin(User user){
        User u = userDataAccess.login(user.getEmail(),user.getPassword());
        String message = "Login or password incorrect";
        System.out.println(u);
        System.out.println(user);
        if(u == null){
            throw new AuthException(message);
        }
        return u;
    }
    public User find(String email){
        return userDataAccess.findUserByEmail(email);
    }
}
