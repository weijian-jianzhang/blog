package com.stx.web;


import com.stx.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) arg0;
        HttpServletResponse resp = (HttpServletResponse) arg1;
        User user =(User)req.getSession().getAttribute("user");
        if (user!=null){
            filterChain.doFilter(req, resp);
        }else {
            if (req.getRequestURI().contains("userServlet")||req.getRequestURI().contains("login")||req.getRequestURI().contains("reg")||req.getRequestURI().contains("forget")){
                filterChain.doFilter(req, resp);
            }else {
                req.getRequestDispatcher("blogsystem/login.jsp").forward(req,resp);
                System.out.println("拦截");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
