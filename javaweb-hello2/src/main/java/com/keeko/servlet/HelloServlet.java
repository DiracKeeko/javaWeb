package com.keeko.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        // 相应的类型： html
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8"); // 输出中文"你好" 不指定utf-8会乱码

        // 获取相应的输出流
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>cus!</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>cus!</h1>");
        out.println("<h2>你好</h2>");
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
