<%@ page import="com.javaweb.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: shahin
  Date: 03/11/2023
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Confirm</title>
</head>
<body>
Are you sure to delete this record?

<%
  Product product = (Product) request.getAttribute("product");
%>
<form method="post" action="/deleteProduct">
  <table>
    <tr><td>Name</td><td><%=product.getName()%></td></tr>
    <tr><td>Model</td><td><%=product.getModel()%></td></tr>
    <tr><td>Factory</td><td><%=product.getFactory()%><input type="hidden" name="id" value="<%=product.getId()%>"></td></tr>
    <tr><td></td><td><input type="submit" name="Submit" value="Yes"><input type="submit" name="Cancel" value="No"></td></tr>
  </table>
</form>
</body>
</html>
