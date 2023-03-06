package com.keeko.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        // 得到Session
        HttpSession session = req.getSession();
        // 在session中存东西
        session.setAttribute("name", "Potato");
        // 获取Session中的ID
        String id = session.getId();

        // 判断Session是否为新创建的
        if(session.isNew()){
            resp.getWriter().write("session创建成功！ID:" + id);
        }else{
            resp.getWriter().write("session已经在服务器中存在了！ID:" + id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
