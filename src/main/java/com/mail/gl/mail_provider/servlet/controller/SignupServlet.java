package com.mail.gl.mail_provider.servlet.controller;

import com.mail.gl.mail_provider.model.User;
import com.mail.gl.mail_provider.service.imp.UserServiceImp;
import com.mail.gl.mail_provider.util.DateParser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserSignupServlet", value = "/users/signup")
public class SignupServlet extends HttpServlet {
    private final UserServiceImp userService = new UserServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user = new User();
            user.setNom(request.getParameter("nom"));
            user.setPrenom(request.getParameter("prenom"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user.setActive(true);
            user.setBirthday(DateParser.parse(request.getParameter("birthday")));
            userService.create(user);
            response.sendRedirect(getServletContext().getContextPath()+"/login");
        } catch (Exception bex){
            bex.printStackTrace();
            response.sendRedirect(getServletContext().getContextPath()+"/signup?error_msg="+bex.getMessage());
        }
    }
}
