package com.keeko.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keeko.util.Constant;


// 让用户不输入密码不能进入主页
public class SysFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        // 把 ServletRequest强制转换成  HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        if (request.getSession().getAttribute(Constant.USER_SESSION) == null) {
            // 注意：/javaweb-filter/ 项目名前面必须要有 /，否则会循环重定向不会停下来
            response.sendRedirect("/error.jsp");
        }

        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}