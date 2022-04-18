package com.mail.gl.mail_provider.servlet.render;

import com.mail.gl.mail_provider.service.EmailService;
import com.mail.gl.mail_provider.service.imp.EmailServiceImp;
import com.mail.gl.mail_provider.util.ReceivingMail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomePageServlet", value = "/")
public class HomePageServlet extends HttpServlet {
    private ReceivingMail receivingMail = new ReceivingMail();
    private EmailService emailService = new EmailServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String email = (String) httpSession.getAttribute("user");
        request.setAttribute("emails",receivingMail.receiving());
        request.setAttribute("sendMails",emailService.retrieveUserEmail(email));
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/view/home.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
