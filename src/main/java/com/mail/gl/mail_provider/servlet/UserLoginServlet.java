package com.mail.gl.mail_provider.servlet;

import com.mail.gl.mail_provider.model.User;
import com.mail.gl.mail_provider.service.CrudService;
import com.mail.gl.mail_provider.service.imp.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", value = "/users/login")
public class UserLoginServlet extends HttpServlet {
    private CrudService<User> userCrudService = new UserServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pwd = request.getParameter("password");
    }
}
