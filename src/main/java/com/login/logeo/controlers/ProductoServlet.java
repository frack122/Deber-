package com.login.logeo.controlers;

import com.login.logeo.models.Producto1;
import com.login.logeo.services.LoginService;
import com.login.logeo.services.LoginServiceImplement;
import com.login.logeo.services.ProductoService;
import com.login.logeo.services.ProductoServiceImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productosServlet","/productos"})
public class ProductoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener parámetros de la solicitud
        String categoria = request.getParameter("categoria");

        // Instanciar servicios
        ProductoService productoService = new ProductoServiceImplement();
        LoginService authService = new LoginServiceImplement();

        // Obtener lista de productos según la categoría (si se proporcionó)
        List<Producto1> productos;
        if (categoria != null && !categoria.isEmpty()) {
            productos = productoService.listarPorCategoria(categoria);
        } else {
            productos = productoService.listarPorCategoria(categoria);
        }

        // Obtener nombre de usuario logueado
        Optional<String> usernameOptional = authService.getUserName(request);

        // Configurar respuesta HTTP
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Carritos de Compras</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Lista de Productos </h1> ");
            if (usernameOptional.isPresent()) {
                out.println("<div style='color:green;'> Hola : " + usernameOptional.get() + ", Bienvenido!</div>");
            }
            out.println("<table style='border:1px solid black;'>");
            out.println("<tr>");
            out.println("<td>ID</td>");
            out.println("<th>Nombre</th>");
            out.println("<th>Categoría</th>");
            out.println("<td>Descripción</td>");
            if (usernameOptional.isPresent()) {
                out.println("<td>Valor</td>");
            }
            out.println("<tr>");
            productos.forEach(p -> {
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getNombre() + "</td>");
                out.println("<td>" + p.getCategoria() + "</td>");
                out.println("<td>" + p.getDescripcion() + "</td>");
                if (usernameOptional.isPresent()) {
                    out.println("<td>" + p.getPrecio() + "</td>");
                }
                out.println("</tr>");
            });
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
