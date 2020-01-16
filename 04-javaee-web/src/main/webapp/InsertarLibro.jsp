<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 1/11/20
  Time: 10:21 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>

<%
    String isbn = request.getParameter("isbn");
    String titulo = request.getParameter("titulo");
    String categoria = request.getParameter("categoria");

    Connection conexion = null;
    Statement sentencia = null;

    String URL = "jdbc:mysql://mysql02.c4utrkzk5zgf.us-west-1.rds.amazonaws.com:3306/isil_db";
    String USER = "isil";
    String PASSWORD = "isil";

    int filas = 0;

    try {

        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(URL, USER, PASSWORD);

        sentencia = conexion.createStatement();

        String SQL = "INSERT INTO libros(isbn, titulo,categoria) VALUE ('"+isbn+"', '"+titulo+"', '"+categoria+"' )";

        filas = sentencia.executeUpdate(SQL);

        response.sendRedirect("MostrarLibros.jsp");

    }catch (ClassNotFoundException e){
        System.out.println("Error en la carga del driver " + e.getMessage());
    }catch (SQLException e){
        System.out.println("Error accediendo a la base de datos " + e.getMessage());
    }finally {
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
