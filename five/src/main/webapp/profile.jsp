
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("username")==null){
        response.sendRedirect("/login.jsp");
    }else {
%>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<a href="/logout">Logout</a><br>
Welcome to Profile
</body>
</html>
<% } %>
