<%@ page import="pe.isil.model.User" %><%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 1/18/20
  Time: 07:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>

    <h1> Bienvenido  <%= ((User) session.getAttribute("user")).getLogin() %> </h1>

</body>
</html>
