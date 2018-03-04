<%--
  Created by IntelliJ IDEA.
  User: strokov
  Date: 03.03.18
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>
    <form action="/login" method="post">
    Login:<input type="text" name="login"><br>
    Password:<input type="password" name="password"><br>
    <input type="submit" value="log in">
    </form>
</body>
</html>
