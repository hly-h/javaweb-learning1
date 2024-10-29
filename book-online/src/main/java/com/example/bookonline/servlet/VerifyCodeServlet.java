package com.example.bookonline.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/verifyCode")
public class VerifyCodeServlet extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int width=160;
            int height=45;

            //1.创建验证码图片对象
            BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

            //2.美化图片 创建画笔对象
            Graphics g=image.getGraphics();
            //设置画笔颜色
            g.setColor(Color.white);
            g.fillRect(0,0,width,height);
            String str="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHILKLMNOPQRSTUVWXYZ";
            //生成随机角标
            Random random=new Random();
            StringBuilder verifyCode = new StringBuilder();
            for(int i=0;i<=4;i++){
                int index=random.nextInt(str.length());
                //获取随机字符
                char ch=str.charAt(index);
                verifyCode.append(ch);
                //设置字体颜色
                Color color=new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
                g.setColor(color);
                Font font=new Font("Dialog",Font.BOLD,20);
                g.setFont(font);
                //填写验证码
                g.drawString(ch+" ",width/5*i,height/2);
            }

            //生成干扰线

            //g.setColor(Color.cyan);
            //随机生成坐标点
            for(int i=0;i<10;i++){
                int x1=random.nextInt(width);
                int x2=random.nextInt(width);
                int y1=random.nextInt(height);
                int y2=random.nextInt(height);
                Color color=new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
                g.drawLine(x1,x2,y1,y2);
                g.setColor(color);
            }

        // 将生成的验证码存储到session中
//        req.getSession().setAttribute("verificationCode", verifyCode.toString().toUpperCase());
            String captcha = verifyCode.toString();
            HttpSession session = req.getSession();
            session.setAttribute("captcha", captcha);
        System.out.println(captcha);
            //将验证码图片展示到页面上
            ImageIO.write(image,"jpg",resp.getOutputStream());
        }
}
