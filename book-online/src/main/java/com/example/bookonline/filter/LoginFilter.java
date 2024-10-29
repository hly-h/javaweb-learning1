package com.example.bookonline.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html;charset=utf-8");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //放行不需要登录就可以访问的路径
        String[] urls = {"/images/", "/css/", "/login.html", "/login-page", "/login","/verifyCode"};
        //获取请求路径
        String requestUrl = request.getRequestURL().toString();
        for (String url : urls) {
            if (requestUrl.contains(url)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
            //资源放行
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            request.getRequestDispatcher("/login.html").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
