package com.mail.gl.mail_provider.servlet;

import com.mail.gl.mail_provider.model.User;
import com.mail.gl.mail_provider.service.CrudService;
import com.mail.gl.mail_provider.service.imp.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserRegisterServlet", value = "/users/register")
public class UserRegisterServlet extends HttpServlet {
    private CrudService<User> userCrudService = new UserServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setNom(request.getParameter("nom"));
        user.setPrenom(request.getParameter("prenom"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        userCrudService.create(user);
        response.sendRedirect("/login.jsp");
    }
}
