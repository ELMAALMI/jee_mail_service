package com.mail.gl.mail_provider.servlet.controller;

import com.mail.gl.mail_provider.model.Email;
import com.mail.gl.mail_provider.util.ReceivingMail;
import com.mail.gl.mail_provider.util.SendMail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MailServlet", value = "/send-mail")
public class MailServlet extends HttpServlet {
    private SendMail mail = new SendMail();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Email email = new Email();
        HttpSession httpSession = request.getSession();
        String from_email = (String) httpSession.getAttribute("user");
        email.setFrom(from_email);
        email.setMessage(request.getParameter("message"));
        email.setTo(request.getParameter("to"));
        email.setObjet(request.getParameter("objet"));
        //mail.send(email);
        //receivingMail.receiving();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
