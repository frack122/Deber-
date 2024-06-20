package com.login.logeo.controlers;

import com.login.logeo.models.Producto1;
import com.login.logeo.repositorio.ProductoRepositoryJdbcImpl;
import com.login.logeo.services.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productosServlet","/productos"})
public class ProductoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener parámetros de la solicitud
        // String categoria = request.getParameter("categoria");
        /*Obtenemnos la ccnexion */
        Connection conn =(Connection) request.getAttribute("conn");
        // Instanciar servicios
        // ProductoService productoService = new ProductoRepositoryJdbcImpl(conn);
        ProductoService service = new ProductoServiceJdbcImplement(conn);
        LoginService authService = new LoginServiceImplement();

        // Obtener lista de productos según la categoría (si se proporcionó)
        List<Producto1> productos = service.listar();
       /* if (categoria != null && !categoria.isEmpty()) {
            productos = productoService.listar();
        } else {
            productos = productoService.listar();
        }*/

        // Obtener nombre de usuario logueado
        Optional<String> usernameOptional = authService.getUserName(request);

        // Configurar respuesta HTTP
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            response.sendRedirect(request.getContextPath()+"/ProductoServlet.jsp");
        }
    }
}