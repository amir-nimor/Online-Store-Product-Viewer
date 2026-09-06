<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 9/6/2026
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Affordable Products</title>
</head>
<body>
<center>
    <h1>Affordable Products</h1>

    <c:forEach varara="${items}" items="${items}">
        <li>${item.name}</li>
    </c:forEach>
    <a href="./index.jsp">go back</a>
</center>


</body>
</html>
