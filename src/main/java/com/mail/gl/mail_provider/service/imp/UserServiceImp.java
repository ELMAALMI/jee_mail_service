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
    public void create(User o) {
        User u = userDataAccess.findUserByEmail(o.getEmail());
        System.out.println(u);
        if(u != null){
            throw new BadRequestException("email already taken");
        }
        o.setPassword(bCryptPasswordEncoder.cryptPassword(o.getPassword()));
        System.out.println(o.getPassword());
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

    @Override
    public User find() {
        return null;
    }

    public void userLogin(User user){
        User u = userDataAccess.findUserByEmail(user.getEmail());
        String message = "Login or password incorrect";
        System.out.println(u);
        System.out.println(user);
        if(u == null){
            throw new AuthException(message);
        }else {
            boolean isAuthenticated = bCryptPasswordEncoder
                    .authenticate(user.getPassword(),u.getPassword());
            System.out.println(isAuthenticated);
            if(!isAuthenticated){
                throw new AuthException(message);
            }
        }
    }
    public User find(String email){
        return userDataAccess.findUserByEmail(email);
    }
}
