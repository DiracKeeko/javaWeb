package com.keeko.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 这种写法 import的时候不需要static
import com.keeko.util.Constant;

// 登录页面
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取前端请求的参数
        String username = req.getParameter("username");
        System.out.println("aaa: --------------------> " + username);
        if (username.equals("admin")) {
            // 登录成功
            // "Constant.USER_SESSION"这种写法  import的时候不需要static
            req.getSession().setAttribute(Constant.USER_SESSION, req.getSession().getId());
            resp.sendRedirect("/sys/success.jsp");
        } else {
            // 登录失败
            resp.sendRedirect("/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("123");
        // TODO Auto-generated method stub
        doGet(req, resp);
    }
}
