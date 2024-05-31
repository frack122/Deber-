<%--
  Created by IntelliJ IDEA.
  User: ESTUDIANTE
  Date: 30/5/2024
  Time: 8:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ingresando al Sistema</title>
</head>
<body>
<h1>Iniciar Sesion</h1>
<form action="ServletLogin" method="post">
    <div class="container">
       <div>
           <label for="username">Ingrerse el nombre</label>
           <input type="text" name="username" id="username">
       </div>
        <div>
            <label for="password">Ingrese la contrase</label>
            <input type="password" name="password" id="password">
        </div>
        <div>
            <input type="submit" value="Login">
        </div>
    </div>

</form>
</body>
</html>
