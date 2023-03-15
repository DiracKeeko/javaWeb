package com.keeko.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    // 初始化: tomcat(web服务器)启动的时候，就初始化了，随时等待过滤对象出现。
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化");
    }

    // chain 链
    /*
    * 1、过滤器中的所有代码，在过滤特定请求的时候都会执行。
    * 2、必须要让过滤器继续通行。（请求向后转交）
    *       filterChain.doFilter(servletRequest, servletResponse);
    * */
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        System.out.println("CharacterEncodingFilter执行前");
        filterChain.doFilter(servletRequest, servletResponse); // 让请求继续走下去，如果不写，程序到这里停止
        System.out.println("CharacterEncodingFilter执行后");
    }

    // 销毁: tomcat(web服务器)关闭的时候过滤器销毁
    public void destroy() {
        // System.gc();
        System.out.println("CharacterEncodingFilter销毁");
    }
}
