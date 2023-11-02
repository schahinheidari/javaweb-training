<%--
  Created by IntelliJ IDEA.
  User: shahin
  Date: 29/10/2023
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Product</title>
</head>
<body>
<form method="post" action="/insertProduct">
    <table>
        <tr><td>Name</td><td><input type="text" name="name"></td></tr>
        <tr><td>Model</td><td><input type="text" name="model"></td></tr>
        <tr><td>Factory</td><td><input type="text" name="factory"></td></tr>
        <tr><td></td><td><input type="submit" name="Insert" value="Insert"></td></tr>
    </table>
</form>
</body>
</html>
