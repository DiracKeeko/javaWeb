package com.keeko.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// 统计网站在线人数 -> 统计session
public class OnlineCountListener implements HttpSessionListener {
    // 创建session监听
    // 一旦创建session就会触发这个事件
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext ctx = httpSessionEvent.getSession().getServletContext();
        System.out.println(httpSessionEvent.getSession().getId());
        Integer onlineCount = (Integer) ctx.getAttribute("accCount");
        if (onlineCount == null) {
            onlineCount = new Integer(1);
        } else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count + 1);
        }

        ctx.setAttribute("accCount", onlineCount);
    }

    // 销毁session监听
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext ctx = httpSessionEvent.getSession().getServletContext();
        Integer onlineCount = (Integer) ctx.getAttribute("accCount");
        if (onlineCount == null) {
            onlineCount = new Integer(1);
        } else {
            int count = onlineCount.intValue();
            onlineCount = new Integer(count - 1);
        }

        ctx.setAttribute("accCount", onlineCount);
    }
}
