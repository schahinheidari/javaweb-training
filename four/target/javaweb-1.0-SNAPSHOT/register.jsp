<%--
  Created by IntelliJ IDEA.
  User: shahin
  Date: 01/11/2023
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<%
    String color = "White";
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie :
            cookies) {
        if (cookie.getName().equals("color")) {
            color = cookie.getValue();
            break;
        }
    }
%>
<body bgcolor="<%=color%>">

</body>
</html>
