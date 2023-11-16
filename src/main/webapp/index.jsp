<%--
  Created by IntelliJ IDEA.
  User: markutan
  Date: 16.11.23
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <form action="points-servlet" method="post">
        <label for="start">Start:</label><input id="start" type="text" name="start">
        <label for="end">End: </label><input id="end" type="text" name="end">
        <label for="step">Step: </label><input id="step" type="text" name="step">
        <input type="submit" value="Count"/>
</form>
</body>
</html>
