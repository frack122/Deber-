<%--
  Created by IntelliJ IDEA.
  User: ESTUDIANTE
  Date: 30/5/2024
  Time: 8:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Ingresando al Sistema</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background: #f0f0f0;
        }
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            border: 1px solid;
            width: 400px;
            height: 500px;
            background: url('assets/buildings.png') center / cover no-repeat;
            color: white;
            border-radius: 20px;
            box-shadow: 0px 0px 20px rgba(0,0,0,0.75);
            position: relative;
        }
        .container::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background: rgba(0, 0, 0, 0.5);
            border-radius: 20px;
            z-index: 1;
        }
        form {
            display: flex;
            flex-direction: column;
            box-sizing: border-box;
            padding: 40px;
            width: 100%;
            height: 100%;
            backdrop-filter: brightness(40%);
            gap: 5px;
            z-index: 2;
        }
        h1 {
            font-weight: normal;
            font-size: 24px;
            text-shadow: 0px 0px 2px rgba(0,0,0,0.5);
            margin-bottom: 60px;
            text-align: center;
        }
        label {
            color: rgba(255,255,255,0.8);
            text-transform: uppercase;
            font-size: 10px;
            letter-spacing: 2px;
            padding-left: 10px;
        }
        input {
            background: rgba(255,255,255,0.3);
            height: 40px;
            line-height: 40px;
            border-radius: 20px;
            padding: 0px 20px;
            border: none;
            margin-bottom: 20px;
            color: white;
        }
        button {
            background: rgba(45,126,231,1);
            height: 40px;
            line-height: 40px;
            border-radius: 40px;
            border: none;
            margin: 10px 0px;
            box-shadow: 0px 0px 5px rgba(0,0,0,0.3);
            color: white;
            font-size: 12px;
            text-transform: uppercase;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="ServletLogin" method="post">
        <h1>Iniciar Sesión</h1>
        <div>
            <label for="username">Ingrese el nombre</label>
            <input type="text" name="username" id="username" required>
        </div>
        <div>
            <label for="password">Ingrese la contraseña</label>
            <input type="password" name="password" id="password" required>
        </div>
        <div>
            <button type="submit">Login</button>
        </div>
    </form>
</div>
</body>
</html>
