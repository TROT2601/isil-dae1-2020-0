<%@ page import="java.util.List" %>
<%@ page import="pe.isil.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 1/18/20
  Time: 09:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


    <title>Productos</title>
</head>
<body>

    <div class="container">

        <h1>Listado de Productos</h1>

        <div>
            <a href="producto?action=nuevo" class="btn btn-primary" role="button">Crear Producto</a>
        </div>
        <!-- Content here -->
        <table class="table table-bordered table-striped table-hover">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Category</th>
                <th>Price</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${products}">

                <tr>
                    <td> <c:out value="${product.id}"></c:out> </td>
                    <td> <c:out value="${product.name}"></c:out> </td>
                    <td> <c:out value="${product.category}"></c:out> </td>
                    <td> <c:out value="${product.price}"></c:out> </td>
                    <td>
                        <a class="btn btn-primary" href="producto?action=update&id=<c:out value="${product.id}" />" >Editar</a>
                        <a class="btn btn-primary" href="producto?action=delete&id=<c:out value="${product.id}" />" >Borrar</a>
                    </td>
                </tr>

            </c:forEach>

            </tbody>

        </table>
    </div>


</body>
</html>
