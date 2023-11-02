<html>
<body>
<%
    Integer counter = (Integer) application.getAttribute("counter");
    if (counter == null){
        counter = 0;
    }
    counter++;
    application.setAttribute("counter", counter);
%>
This page has been seen <%=counter%> times!<br>
Welcome to Index Page
</form>
</body>
</html>
