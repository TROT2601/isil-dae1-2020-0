<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 1/15/20
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="pe.isil.util.DataBaseHelper" %>

<html>
<head>
    <title>Lista de Libros</title>
</head>
<body>

<%

    ResultSet resultSet = null;

    try {
        String SQL = "SELECT isbn, titulo, categoria FROM libros";
        DataBaseHelper db = new DataBaseHelper();
        resultSet = db.seleccionarRegistros(SQL);
        while (resultSet.next()){
 %>
                <%= resultSet.getString("isbn") %>
                <%= resultSet.getString("titulo") %>
                <%= resultSet.getString("categoria") %>
                    <br/>
<%
        }

        } catch (SQLException e){
            System.out.println("Error accediendo a la base de datos " + e.getMessage());
        }finally {

            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("Error cerrando el resultset "+ e.getMessage());
                }
            }
        }

%>


</body>
</html>
