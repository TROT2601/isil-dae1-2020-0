<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 1/11/20
  Time: 9:48 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bienvenidos!</title>
</head>
<body>
    <h1>Bienvenidos a DAE1</h1>

    <%
        java.util.Date fechaHora = new java.util.Date();

        out.print("La fecha y Hora son: " + fechaHora);
    %>

</body>
</html>
