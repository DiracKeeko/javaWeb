<%@ page import="com.keeko.util.Constant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<%
    Object userSession = request.getSession().getAttribute(Constant.USER_SESSION);
    if (userSession == null) {
        response.sendRedirect("/login.jsp");
    }
%>
    <h1>主页</h1>
    <h3>admin</h3>
    <p><a href="/servlet/logout">注销</a></p>
</body>
</html>
