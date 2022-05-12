package com.mail.elmaalmi.billal.servlet.controller;

import com.mail.elmaalmi.billal.exception.AuthException;
import com.mail.elmaalmi.billal.model.User;
import com.mail.elmaalmi.billal.service.UserService;
import com.mail.elmaalmi.billal.service.imp.UserServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", value = "/users/login")
public class UserLoginServlet extends HttpServlet {
    private final UserService userServiceImp = new UserServiceImp();
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
            user.setAdmin(userServiceImp.userLogin(user).isAdmin());
            //--------------
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user",user);
            //--------------------
            response.sendRedirect(getServletContext().getContextPath());
        } catch (AuthException e) {
            response.sendRedirect(getServletContext().getContextPath()+"/login?message="+e.getMessage());
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
