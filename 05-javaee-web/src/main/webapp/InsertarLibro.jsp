<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 1/11/20
  Time: 10:21 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="pe.isil.model.Libro" %>
<%@ page import="pe.isil.dao.LibroDAO" %>

<%
    String isbn = request.getParameter("isbn");
    String titulo = request.getParameter("titulo");
    String categoria = request.getParameter("categoria");

    Libro libro = new Libro(isbn, titulo, categoria);
    LibroDAO dao = new LibroDAO();
    dao.crear(libro);

    response.sendRedirect("MostrarLibros.jsp");
%>
