package com.mail.gl.mail_provider.servlet.controller;

import com.mail.gl.mail_provider.exception.AuthException;
import com.mail.gl.mail_provider.model.User;
import com.mail.gl.mail_provider.service.imp.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", value = "/users/login")
public class UserLoginServlet extends HttpServlet {
    private final UserServiceImp userServiceImp = new UserServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String login = request.getParameter("email");
            String pwd = request.getParameter("password");
            User user = new User();
            user.setPassword(pwd);
            user.setEmail(login);
            userServiceImp.userLogin(user);
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user",user.getEmail());
            response.sendRedirect(getServletContext().getContextPath());
        } catch (AuthException e) {
            response.sendRedirect(getServletContext().getContextPath()+"/login?message="+e.getMessage());
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}