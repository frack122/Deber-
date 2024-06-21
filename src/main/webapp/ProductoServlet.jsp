<%--
  Created by IntelliJ IDEA.
  User: ESTUDIANTE
  Date: 19/6/2024
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.login.logeo.models.Producto1" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.login.logeo.services.ProductoService" %>
<%@ page import="com.login.logeo.services.ProductoServiceJdbcImplement" %>
<%@ page import="com.login.logeo.services.LoginService" %>
<%@ page import="com.login.logeo.services.LoginServiceImplement" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%
    // Obteniendo la conexión y los servicios desde los atributos de la solicitud
    Connection conn = (Connection) request.getAttribute("conn");
    ProductoService service = new ProductoServiceJdbcImplement(conn);
    LoginService authService = new LoginServiceImplement();

    // Obtener lista de productos
    List<Producto1> productos = service.listar();

    // Obtener nombre de usuario logueado
    Optional<String> usernameOptional = authService.getUserName(request);
%>
<html>
<head>
    <title>Carrito de Compras</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f67f7f; }
        .container { max-width: 700px; margin: 50px auto; background-color: #ffffff; border-radius: 8px; padding: 20px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); }
        h1, p { color: #333; }
        table { border-collapse: collapse; width: 100%; }
        td, th { border: 1px solid black; padding: 8px; text-align: left; }
    </style>
</head>
<body>
<center>
    <h1>Lista de Productos para comprar</h1>
</center>
<div class="container">
    <form action="index.html" method="post">
        <center>
            <%
                if (usernameOptional.isPresent()) {
            %>
            <div>Hola, <%= usernameOptional.get() %>: ¡Bienvenido!</div>
            <p><a href="<%= request.getContextPath()%>/formulario">Agregar nuevos productos</a></p>
            <%
                }
            %>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Categoría</th>
                    <th>Descripción</th>
                    <% if (usernameOptional.isPresent()) { %>
                    <th>Valor</th>
                    <th>Acción</th>
                    <th>Stock</th>
                    <th>Agregar Producto</th>
                    <th>Eliminar Producto</th>
                    <% } %>
                </tr>
                <%
                    for (Producto1 p : productos) {
                %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getNombre() %></td>
                    <td><%= p.getCategoria().getIdCategoria() %></td>
                    <td><%= p.getDescripcion() %></td>
                    <% if (usernameOptional.isPresent()) { %>
                    <td><%= p.getPrecio() %></td>
                    <td><a href="<%= request.getContextPath() %>/agregar-carro?id=<%= p.getId() %>">Agregar al carro</a></td>
                    <td><%=p.getStock()%></td>
                    <td><a href="<%= request.getContextPath() %>/Ingresarlosproductos.jsp?<%%>">Editar</a></td>
                    <td><a href="<%= request.getContextPath() %>/ELIMINARP.jsp<%%>">Eliminar</a></td>
                    <% } %>
                </tr>
                <%
                    }
                %>
            </table>
        </center>
        <br>
        <button type="submit">Retornar</button>
    </form>
</div>
</body>
</html>