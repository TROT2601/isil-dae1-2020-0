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
<%@ page import="pe.isil.dao.LibroDAO" %>
<%@ page import="pe.isil.model.Libro" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Lista de Libros</title>
</head>
<body>

<%

    LibroDAO dao = new LibroDAO();
    List<Libro> libros = dao.listar();

    for (Libro libro: libros) {
 %>
                <%= libro.getIsbn() %>
                <%= libro.getTitle() %>
                <%= libro.getCategoria() %>
                    <br/>
<%
        }

%>

<a href="index.html">insertar Libro</a>
</body>
</html>
