package com.mail.elmaalmi.billal.servlet.controller;

import com.google.gson.Gson;
import com.mail.elmaalmi.billal.model.User;
import com.mail.elmaalmi.billal.util.ReceivingMail;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FindReMailByUuidServlet", value = "/FindReMailByUuidServlet")
public class FindReMailByUuidServlet extends HttpServlet {
    private final ReceivingMail receivingMail = new ReceivingMail();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        String uuid = request.getParameter("uuid");
        System.out.println(uuid);
        response.setContentType("application/json");
        String emailJsonString = new Gson().toJson(
                receivingMail.receiving(user)
                .stream()
                .parallel()
                .filter(e->e.getUuid().equals(uuid))
                        .findFirst()
                        .get()
        );
        PrintWriter out = response.getWriter();
        out.print(emailJsonString);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
