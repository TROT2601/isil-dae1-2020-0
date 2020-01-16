<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 1/15/20
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>

<html>
<head>
    <title>Lista de Libros</title>
</head>
<body>

<%
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultSet = null;

    String URL = "jdbc:mysql://mysql02.c4utrkzk5zgf.us-west-1.rds.amazonaws.com:3306/isil_db";
    String USER = "isil";
    String PASSWORD = "isil";

    try {
        conexion = DriverManager.getConnection(URL, USER, PASSWORD);

        sentencia = conexion.createStatement();

        String SQL = "SELECT isbn, titulo, categoria FROM libros";

        resultSet = sentencia.executeQuery(SQL);

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
                    e.printStackTrace();
                }
            }

            if(sentencia != null){
                try{
                    sentencia.close();
                }catch (SQLException e){
                    System.out.println("e = " + e);
                }
            }
            if(conexion != null){
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("e = " + e);
                }
            }
        }

%>


</body>
</html>
