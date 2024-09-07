package com.example.class01servlet;


import jakarta.servlet.*;

import java.io.IOException;

/**
 * @author ycshang
 * @description: Servlet 初体验
 * @date 2024-09-03 下午4:17
 */
public class ServletDemo1 implements Servlet {

    /**
     * Servlet 初始化
     * 初始化方法，只调用一次
     *
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("ServletDemo1 初始化");

    }

    /**
     * 获取Servlet 配置
     *
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务得方法
     *
     * @param servletRequest  请求参数
     * @param servletResponse 响应参数
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.getWriter().write("ServletDemo1 Service 方法");

    }

    /***
     * 获取 Servlet信息
     * @return
     */
    @Override
    public String getServletInfo() {
        return "";
    }

    /**
     * 销毁方法
     */
    @Override
    public void destroy() {
        System.out.println("Servlet 销毁");
    }
}
