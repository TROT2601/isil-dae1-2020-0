<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 1/18/20
  Time: 07:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <h1>Login</h1>
    <form method="post" action="login">
        <table>
            <tr>
                <td>Login: </td>
                <td> <input name="txtLogin" type="text" value="${login}" > </td>
            </tr>
            <tr>
                <td>Password: </td>
                <td> <input name="txtPassword" type="password" value="${password}" > </td>
            </tr>
            <tr>
                <input type="submit" value="Login" >
            </tr>
            <tr>
                <td> ${errorMessage} </td>
            </tr>


        </table>
    </form>

</body>
</html>
