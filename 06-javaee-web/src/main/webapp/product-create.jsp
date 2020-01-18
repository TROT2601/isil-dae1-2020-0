<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 1/18/20
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


    <title>Crear Producto</title>
</head>
<body>

    <div class="container">

        <form method="post" action="producto">

            <div class="form-group">
                <label for="txtName">nombre </label>
                <input type="text" class="form-control" id="txtName" name="txtName">
            </div>

            <div class="form-group">
                <label for="txtCategory">Categoria</label>
                <input type="text" class="form-control" id="txtCategory" name="txtCategory"  >
            </div>

            <div class="form-group">
                <label for="txtPrice">Precio</label>
                <input type="text" class="form-control" id="txtPrice" name="txtPrice"  >
            </div>

            <button type="submit" class="btn btn-primary">Crear</button>

        </form>

    </div>

</body>
</html>
