package servletContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/servletContextDemo04")
public class ServletContextDemo04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext servletContext=req.getServletContext();
        //webapp 目录下资源访问
        String aPath= servletContext.getRealPath("/a.txt");
        System.out.println("a.txt 文件地址"+aPath);

        //获取WEB-INF目录下的资源
        String bPath=servletContext.getRealPath("/WEB-INF/b.txt");
        System.out.println("b.txt 文件地址"+bPath);

        String cPath= servletContext.getRealPath("/WEB-INF/classes/c.txt");
        System.out.println("c.txt 文件地址"+cPath);

        //读取文件资源
        File file=new File(aPath);
        InputStream in=new FileInputStream(file);
        int read=0;
        ServletOutputStream out=resp.getOutputStream();
        while ((read=in.read())!=-1){
            out.write(read);
        }
        out.flush();
        out.close();
    }
}
