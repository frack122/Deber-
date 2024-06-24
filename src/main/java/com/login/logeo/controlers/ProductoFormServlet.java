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
import java.util.HashMap;
import java.util.Map;
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
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*Obtenemos la conexion */
        Connection connection = (Connection) req.getAttribute("conn");
        ProductoService service = new ProductoServiceJdbcImplement(connection);
        String nombre = req.getParameter("nombre");
        Integer idCategoria;
        try {
            idCategoria=Integer.valueOf(req.getParameter("categoria"));
        }catch (NumberFormatException e){
            idCategoria = 0;
            throw new ServletException("la id de la categoria no es valido");
        }
        String descripcion = req.getParameter("descripcion");
        double precio;
        try{
            precio=Double.valueOf(req.getParameter("precio"));
        }catch (NumberFormatException e){
            precio = 0;
        }
        Integer idProducto;
        try{
            idProducto=Integer.valueOf(req.getParameter("idProducto"));
        }catch (NumberFormatException e){
            idProducto = 0;
        }
        Map<String,String> errores=new HashMap<>();
        if(nombre == null || nombre.isBlank()){
            errores.put("nombre","el campo nombre debe ser requerido");
        }
        if(descripcion == null || descripcion.isBlank()){
            errores.put("descripcion","el campo descripcion debe ser requerido");
        }
        if(precio == 0 ){
            errores.put("precio","el campo precio debe ser positivo");
        }
        if(idCategoria.equals(0)){
            errores.put("categoria","el campo categoria debe ser positivo");
        }
        Producto1 producto = new Producto1();
        producto.setId(idProducto);
        producto.setNombre(nombre);
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCategoria);
        producto.setCategoria(categoria);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        //si el eeror esta vacio ahi me permite guardar el producto
        if (errores.isEmpty()){
            service.guardar(producto);
            resp.sendRedirect("/productos");
        }else {
            req.setAttribute("errores",errores);
            req.setAttribute("categorias",service.listarCategorias());
            req.setAttribute("producto",producto);
            getServletContext().getRequestDispatcher("/ingresodeproductos.jsp").forward(req,resp);
        }
    }
}
