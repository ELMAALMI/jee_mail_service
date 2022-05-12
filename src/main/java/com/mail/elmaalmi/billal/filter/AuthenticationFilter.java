package com.mail.elmaalmi.billal.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter ",urlPatterns = {
        "/",
        "/profile",
        "/send-mail",
        "/admin/*"
})
public class AuthenticationFilter implements Filter {
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
        if(session.getAttribute("user") == null){
            res.sendRedirect(context.getContextPath()+"/login");
        }else {
            chain.doFilter(request, response);
        }
    }
}
