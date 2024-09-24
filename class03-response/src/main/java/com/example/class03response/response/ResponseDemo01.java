package com.example.class03response.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/responseDemo01")
public class ResponseDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        //1.设置响应码
        resp.setStatus(302);
        //2.设置响应头：location
        //resp.setHeader("location","/responseDemo02");
        //3.设置编码
        resp.setContentType("text/html;charset=utf-8");
        //设置响应结果
        resp.getWriter().write("你好 ResponseDemo01");
    }
}
