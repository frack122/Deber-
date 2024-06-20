<%--
  Created by IntelliJ IDEA.
  User: ESTUDIANTE
  Date: 13/6/2024
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.login.logeo.models.*"%>
<%Carro carro = (Carro) session.getAttribute("carro");%>
<html>
<head>
    <title>Carro de compras</title>
</head>
<body>
    <h1>Carro de compras</h1>
    <%
        if(carro == null || carro.getItems().isEmpty()){%>
    <p>Lo sentimos no hay carrito de compras!</p>
    <%}else{%>
    <table>
        <tr>
            <th>Id Producto</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th></th>
        </tr>
        <%for(itemCarro item:carro.getItems()){%>
        <tr>
            <td><%=item.getProducto1().getId()%></td>
            <td><%=item.getProducto1().getNombre()%></td>
            <td><%=item.getProducto1().getPrecio()%></td>
            <td><%=item.getCantidad()%></td>
            <td><%=item.getImporte()%></td>
        </tr>
        <%}%>
        <tr>
            <td content="4">Total:</td>
            <td><%=carro.gettotal()%></td>
        </tr>
    </table>
    <%}%>
    <p><a href="<%=request.getContextPath()%>/productos">Seguir Comprando</a></p>
    <p><a href="<%=request.getContextPath()%>/index.html">volver</a></p>
</body>
</html>
