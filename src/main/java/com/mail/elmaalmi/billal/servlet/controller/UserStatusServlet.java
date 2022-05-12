package com.mail.elmaalmi.billal.servlet.controller;

import com.mail.elmaalmi.billal.service.UserService;
import com.mail.elmaalmi.billal.service.imp.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserStatusServlet", value = "/users-status")
public class UserStatusServlet extends HttpServlet {
    private UserService userService = new UserServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        boolean active = Boolean.parseBoolean(request.getParameter("active"));
        userService.changeUserStatus(id,!active);
        response.sendRedirect(getServletContext().getContextPath()+"/admin");
    }
}
