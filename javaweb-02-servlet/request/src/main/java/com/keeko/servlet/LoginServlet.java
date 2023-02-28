package com.keeko.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 处理接收中文乱码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobbies");

        System.out.println("==========");
        System.out.println(username);
        System.out.println(password);
        System.out.println(Arrays.toString(hobbies)); // 打印中文会乱码
        System.out.println("==========");

        // 请求转发
        // ↓ 在 getRequestDispatcher() 中 "/" 会被识别为当前web应用 如果tomcat配置为"/res"  "/" -> "res"
        req.getRequestDispatcher("/success.jsp").forward(req, resp); // 请求转发

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
