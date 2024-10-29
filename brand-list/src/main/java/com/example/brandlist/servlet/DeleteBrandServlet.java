package com.example.brandlist.servlet;

import com.alibaba.fastjson.JSON;
import com.example.brandlist.entity.Brand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteBrand")
public class DeleteBrandServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 读取请求体中的数据
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        // 将请求体中的JSON字符串转换为Brand对象
        // 这里使用了fastjson库进行JSON解析
        Brand brandToDelete = JSON.parseObject(sb.toString(), Brand.class);
        // 从ServletContext中获取品牌列表
        List<Brand> brands = (List<Brand>) req.getServletContext().getAttribute("brands");

        //使用removeIf方法从品牌列表中移除与请求中的品牌ID相匹配的品牌
        if (brands != null) {
            // removeIf方法会遍历整个列表，如果lambda表达式的条件为true，则移除该元素
            brands.removeIf(brand -> brand.getId() == brandToDelete.getId());
            // 更新ServletContext中的品牌列表
            req.getServletContext().setAttribute("brands", brands);
        }
    }
}