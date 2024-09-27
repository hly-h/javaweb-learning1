package com.example.bookonline.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/login-page")
public class LoginPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        String action = req.getParameter("action");
        if ("login".equals(action)) {
            req.getRequestDispatcher("login.html").forward(req, resp);
        } else if ("enroll".equals(action)) {
            req.getRequestDispatcher("enroll.html").forward(req, resp);
        } else {
            // 默认页面，例如登录页面
            req.getRequestDispatcher("login.html").forward(req, resp);
        }
    }
}
