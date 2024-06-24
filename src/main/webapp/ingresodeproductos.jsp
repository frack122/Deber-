<%@ page import="java.util.List" %>
<%@ page import="com.login.logeo.models.Categoria" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.login.logeo.models.Producto1" %><%--
  Created by IntelliJ IDEA.
  User: ESTUDIANTE
  Date: 20/6/2024
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*, com.login.logeo.models.*"%>
<%
    List<Categoria>categorias=(List<Categoria>) request.getAttribute("categorias");
    Map<String , String>errores= (Map<String , String>) request.getAttribute("errores");
    Producto1 producto = (Producto1) request.getAttribute("producto");
%>
<html>
<head>
    <title>Ingreso de productos</title>
    <style>
        input {
            -webkit-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            width: 100%;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        form{max-width: 500px; margin: 0 auto;}
        textarea {
            width: 300px;
            height: 150px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            resize: none; /* Evita que el usuario pueda redimensionar el textarea */
        }
        .input-container {
            position: relative;
            margin-bottom: 20px;
        }
        .icon-input {
            padding: 10px 15px 10px 45px;
            border: 2px solid #2196F3;
            border-radius: 25px;
            width: 300px;
            font-size: 16px;
            color: #333;
            background-color: #f7f7f7;
            outline: none;
        }
        .input-icon {
            position: absolute;
            top: 50%;
            left: 15px;
            transform: translateY(-50%);
            color: #777;
            font-size: 20px;
        }
    </style>
</head>
<body>
<center>
    <h1>INGRESO DE PRODUCTOS</h1>
</center>
<div class="container">
    <form action="<%=request.getContextPath()%>/formulario" method="post">
        <%--@declare id="idetificacion"--%><label for="id">Ingrese la id correspondiente</label>
        <input name="id" id="id">
            <hr class="my-4">
        <%--@declare id="nombre"--%><label for="producto">Nombre del producto:</label>
        <input name="producto" id="producto">
            <hr class="my-4">
        <%--@declare id="Precio"--%><label for="precio">Precio del producto:</label>
        <input name="precio" id="precio">
            <hr class="my-4">
        <%--@declare id="cantidad"--%><label for="cantidad">Ingrese la cantidad:</label>
        <input name="cantidad" id="cantidad">
            <hr class="my-4">
            <%if(errores!=null && errores.containsKey("nombre")){%>
            <div style="color:red;"<%=errores.get("nombre")%>></div>
            <%}%>
            <div>
                <label for="categoria">Categoria</label>
                <div>
                    <select name="categoria" id="categoria">
                        <option value="">------------Selecionar------------</option>
                        <%for(Categoria c:categorias){%>
                        <option value="<%=c.getIdCategoria()%>"><%=c.getNombre()%></option>
                        <%}%>
                    </select>
                </div>
            </div>
            <hr class="my-4">
            <h2>Comentario</h2>
            <textarea placeholder="Escribe aquí..."></textarea>
            <hr class="my-4">
            <div><input type="submit" value="<%=(producto.getId()!=null && producto.getId()>0 ? "Editar":"Crear")%>"></div>
            <input type="hidden" name="id" value="<%=producto.getId()%>">
    </form>
</div>

</body>
</html>

