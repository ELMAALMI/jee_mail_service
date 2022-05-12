package com.mail.elmaalmi.billal.filter;

import com.mail.elmaalmi.billal.model.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter",urlPatterns ="/admin/*")
public class AdminFilter implements Filter {
    ServletContext context;
    public void init(FilterConfig config) throws ServletException {
        context = config.getServletContext();
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        if( user != null && !user.isAdmin()){
            res.sendRedirect(context.getContextPath());
        }else {
            chain.doFilter(request, response);
        }
    }
}
