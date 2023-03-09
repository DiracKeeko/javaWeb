<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--${pageContext}--%>
<%--${pageScope.}--%>
<%--${sessionScope.get()}--%>

<%-- <% %>可以直接写java代码 --%>
<%
    out.clear();
    session.invalidate();
%>
</body>
</html>
