package com.login.logeo.controlers;

import com.login.logeo.models.Categoria;
import com.login.logeo.models.Producto1;
import com.login.logeo.services.ProductoService;
import com.login.logeo.services.ProductoServiceJdbcImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/formulario")
public class ProductoFormServlet extends HttpServlet {

 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     Connection conn = (Connection) request.getAttribute("conn");
     ProductoService service = new ProductoServiceJdbcImplement(conn);
     if(conn==null){
         System.out.println("error al conectar");
     }else {
         Integer idCategoria ;
         try{
             idCategoria = Integer.parseInt(request.getParameter("id"));
         }catch (NumberFormatException e ){
             idCategoria=0;
         }
         Producto1 producto = new Producto1();
         producto.setCategoria(new Categoria());
         if (idCategoria > 0){
             Optional<Producto1> o = service.porId(idCategoria);
             if (o.isPresent()){
                 producto = o.get();

             }
         }
         request.setAttribute("categorias",service.listarCategorias());
         request.setAttribute("producto",producto);
         getServletContext().getRequestDispatcher("/ingresodeproductos.jsp").forward(request,response);

     }


 }
}
