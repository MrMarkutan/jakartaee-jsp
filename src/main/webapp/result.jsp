<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: markutan
  Date: 15.11.23
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
    <link rel="stylesheet" href="styles.css" type="text/css">
</head>
<body>
<jsp:useBean id="main" class="com.example.jakartaee.logic.Main" scope="request"/>
<p>Start is: ${main.start}, end is: ${main.end}, step is: ${main.step}</p>
<table>
    <thead>
    <tr>
        <th>X</th>
        <th>F(X)</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="p" items="${main.points}">
        <tr>
            <td>${p.x()}</td>
            <td>${p.y()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>Max point is: (${main.max().x()}, ${main.max().y()})</p>
<p>Min point is: (${main.min().x()}, ${main.min().y()})</p>
</body>
</html>
