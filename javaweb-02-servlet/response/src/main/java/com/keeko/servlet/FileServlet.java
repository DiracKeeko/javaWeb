package com.keeko.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 要获取下载文件的路径；
        // 通过idea copy path -> D:\git\java_web\javaweb-02-servlet\response\target\classes\05.png
        // String realPath = this.getServletContext().getRealPath("/05.png"); // 这样不行，指向了 D:\environment\apache-tomcat-9.0.71\webapps\res\05.png -> tomcat的路径

        // String realPath = this.getClass().getClassLoader().getResource("05.png").getPath(); // 这样可以 但文件名变了

        String realPath = "D:\\git\\java_web\\javaweb-02-servlet\\response\\target\\classes\\05.png";
        System.out.println("下载文件的路径:" + realPath);

        // 2. 下载的文件名是啥？
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);

        // 3. 设置想办法让浏览器能够支持（"Content-Disposition"）下载我们需要的东西；
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

        // 4. 获取下载文件的输入流；
        FileInputStream in = new FileInputStream(realPath);

        // 5. 创建缓冲区；
        int len = 0;
        byte[] buffer = new byte[1024];

        // 6. 获取OutputStream对象；
        ServletOutputStream out = resp.getOutputStream();

        // 7. 将FileOutputStream流写入到buffer缓冲区； 使用OutputStream将缓冲区中的数据输出到客户端！
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }

        // 8. 关闭流
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
