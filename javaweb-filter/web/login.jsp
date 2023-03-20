<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>登录</h1>
<!-- 地址前面需要加上项目名 -->
<form action="/servlet/login" method="post">
    <input type="text" name="username">
    <input type="submit">
</form>

</body>
</html>