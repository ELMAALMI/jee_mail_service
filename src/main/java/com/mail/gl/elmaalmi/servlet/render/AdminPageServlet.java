package com.mail.gl.elmaalmi.servlet.render;

import com.mail.gl.elmaalmi.service.UserService;
import com.mail.gl.elmaalmi.service.imp.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminPageServlet", value = "/admin")
public class AdminPageServlet extends HttpServlet {
    private final UserService userService = new UserServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("/admin/users");
        request.setAttribute("users",userService.findAll());
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/view/users.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,
            IOException {
    }
}
