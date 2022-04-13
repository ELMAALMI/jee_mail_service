package com.mail.gl.mail_provider.servlet.render;

import com.mail.gl.mail_provider.service.imp.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProfilePageServlet", value = "/profile")
public class ProfilePageServlet extends HttpServlet {
    private final UserServiceImp userServiceImp = new UserServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String user_email = (String) httpSession.getAttribute("user");
        System.out.println(user_email);
        request.setAttribute("user",userServiceImp.find(user_email));
        getServletContext().getRequestDispatcher("/view/profile.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
