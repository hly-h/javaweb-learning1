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
        String inputCode=req.getParameter("verifyCode");
        String storedCode=(String) req.getSession().getAttribute("captcha");

        // 验证码检查
        if (inputCode != null && inputCode.equalsIgnoreCase(storedCode)) {
            // 非空检查
            if (account.isEmpty() || phone.isEmpty() || password.isEmpty() || nickname.isEmpty() || address.isEmpty()) {
                resp.sendRedirect("/enroll?error=empty_fields");
                return;
            }

            // 调用UserService的注册方法
            boolean registered = userService.signUp(account, phone, password, nickname, address);
            System.out.println(registered);
            if (registered) {
                // 注册成功后，重定向到登录页面
                resp.sendRedirect("/login-page?success=registered");
            } else {
                // 注册失败处理
                resp.sendRedirect("/enroll?error=registration_failed");
            }
        } else {
            req.setAttribute("errorMessage", "验证码错误，请重试！");
            req.getRequestDispatcher("/enroll.html").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
