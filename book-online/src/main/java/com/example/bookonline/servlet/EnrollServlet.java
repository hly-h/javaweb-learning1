package com.example.bookonline.servlet;

import com.example.bookonline.dao.UserDao;
import com.example.bookonline.dao.impl.UserDaoImpl;
import com.example.bookonline.entity.User;
import com.example.bookonline.service.UserService;
import com.example.bookonline.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/enroll")
public class EnrollServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数
        String account = req.getParameter("account");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String address = req.getParameter("address");

        // 非空检查
        if (account == null || phone == null || password == null || nickname == null || address == null ||
                account.trim().isEmpty() || phone.trim().isEmpty() || password.trim().isEmpty() || nickname.trim().isEmpty() || address.trim().isEmpty()) {
            resp.sendRedirect("/enroll?error=empty_fields");
            return;
        }

        // 去除空格
        account = account.trim();
        phone = phone.trim();
        password = password.trim();
        nickname = nickname.trim();
        address = address.trim();

        // 调用UserService的注册方法
        boolean registered = userService.signUp(account, phone, password,nickname, address);

        if (registered) {
            // 注册成功后，重定向到登录页面
            resp.sendRedirect("/login-page?success=registered");
        } else {
            // 注册失败处理
            resp.sendRedirect("/enroll?error=registration_failed");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
