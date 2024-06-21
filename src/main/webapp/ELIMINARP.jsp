<%--
  Created by IntelliJ IDEA.
  User: RAFAEL
  Date: 20/6/2024
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%--
  Created by IntelliJ IDEA.
  User: ESTUDIANTE
  Date: 20/6/2024
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <html>
        <head>
        <title>Ingreso de productos</title>
</head>
<body>
<center>
    <h1>INGRESO DE PRODUCTOS</h1>
</center>
<div class="container">
    <form action="eliminar" method="post">
        <%--@declare id="idetificacion"--%><label for="id">Ingrese la id correspondiente</label>
        <input name="id" id="id">
        <%--@declare id="nombre"--%><label for="producto">Nombre del producto:</label>
        <input name="producto" id="producto">
        <br>
        <%--@declare id="Precio"--%><label for="precio">Precio del producto:</label>
        <input name="precio" id="precio">
        <br>
        <%--@declare id="cantidad"--%><label for="cantidad">Ingrese la cantidad:</label>
        <input name="cantidad" id="cantidad">
        <br>
        <button type="submit">Next</button>
    </form>
</div>

</body>
</html>
</title>
</head>
<body>

</body>
</html>
