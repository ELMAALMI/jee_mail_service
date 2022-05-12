package com.mail.elmaalmi.billal.servlet.controller;

import com.google.gson.Gson;
import com.mail.elmaalmi.billal.service.EmailService;
import com.mail.elmaalmi.billal.service.imp.EmailServiceImp;
import com.mail.elmaalmi.billal.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EmailSendedServlet", value = "/emails")
public class EmailSendedServlet extends HttpServlet {
    private EmailService emailService = new EmailServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        response.setContentType("application/json");
        String emailJsonString = new Gson().toJson(emailService.retrieveUserEmail(user.getEmail()));
        PrintWriter out = response.getWriter();
        out.print(emailJsonString);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
