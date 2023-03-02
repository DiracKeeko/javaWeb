package com.keeko.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

// 保存用户上一次访问的时间
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 服务器，告诉你，你来的时间，将这个时间封装为一个信件, 你带过来我就知道你来了

        // 解决中文乱码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        // Cookie,服务端从客户端获取
        Cookie[] cookies = req.getCookies();
        // 这里返回数组，说明Cookie可能存在多个

        // 判断Cookie是否存在
        if (cookies != null) {
            // 如果存在，遍历数组
            out.write("你上一次访问的时间是:");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                // 获取Cookie的名字
                if (cookie.getName().equals("lastLoginTime")) {
                    // 获得cookie中的value
                    long parseLong = Long.parseLong(cookie.getValue());
                    Date date = new Date(parseLong);
                    out.write(date.toLocaleString()); // toLocalString() 虽然过期了，但比 toString()转化的正规
                }
            }
        } else {
            out.write("第一次访问本站！！！");
        }

        // 服务端给客户端响应一个Cookie;
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis() + "");

        // 设置cookie的有效期 ↓一天 24h * 60min * 60s
        cookie.setMaxAge(24 * 60 * 60);

        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
