package com.example.request;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/requestDemo06")
public class RequestDemo06 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("requestDemo06 请求");
        resp.getWriter().write("RequestDemo06");
        req.setAttribute("msg","hello");

        ServletContext servletContext=req.getServletContext();
        servletContext.setAttribute("info","hello");
    }
}
