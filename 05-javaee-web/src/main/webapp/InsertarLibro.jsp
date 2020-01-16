<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 1/11/20
  Time: 10:21 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="pe.isil.util.DataBaseHelper" %>

<%
    String isbn = request.getParameter("isbn");
    String titulo = request.getParameter("titulo");
    String categoria = request.getParameter("categoria");

    String SQL = "INSERT INTO libros(isbn, titulo,categoria) VALUE ('"+isbn+"', '"+titulo+"', '"+categoria+"' )";

    DataBaseHelper db = new DataBaseHelper();
    int filas = db.modificarRegistro(SQL);
    response.sendRedirect("MostrarLibros.jsp");
%>
