<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 9/6/2026
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AllProducts</title>
</head>
<body>
<h1>AllProducts</h1>
<center>
    <h2>All products</h2>

    <c:forEach var="product" items="${products}">
        <li>${product}</li>
    </c:forEach>

    <a href="./index.jsp">go back</a>
</center>



</body>
</html>
