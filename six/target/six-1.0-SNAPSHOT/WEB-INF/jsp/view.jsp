<%@ page import="com.javaweb.entity.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: shahin
  Date: 02/11/2023
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Products</title>
</head>
<body>
<a href="/insertProduct">Insert New Product</a>
<table border="1">
    <tr>
    <td>Name</td>
    <td>Model</td>
    <td>Factory</td>
    <td></td>
    <td></td>
    </tr>
    <%
        List<Product> products = (List<Product>) request.getAttribute("products");
        if (products != null) {
            for (Product product : products) {
    %>
    <tr>
        <td><%=product.getName()%></td>
        <td><%=product.getModel()%></td>
        <td><%=product.getFactory()%></td>
        <td><a href="/editProduct?id=<%=product.getId()%>">Edit</a></td>
        <td><a href="/deleteProduct?id=<%=product.getId()%>">Delete</a></td>
    </tr>
    <%
            }
        }
    %>

</table>
</body>
</html>
