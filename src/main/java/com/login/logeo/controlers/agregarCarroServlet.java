package com.login.logeo.controlers;

import com.login.logeo.models.Carro;
import com.login.logeo.models.Producto1;
import com.login.logeo.models.itemCarro;
import com.login.logeo.services.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/agregar-carro")
public class agregarCarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idProducto = Integer.parseInt(req.getParameter("id"));
        Connection conn = (Connection) req.getAttribute("conn");
      //  ProductoService service = new ProductoServiceImplement();
        ProductoService service = new ProductoServiceJdbcImplement(conn);
        LoginService authService = new LoginServiceImplement();
        Optional<Producto1> producto = service.porId(idProducto);
        if (producto.isPresent()) {
            itemCarro item = new itemCarro(1, producto.get());
            //Obtenemos la sesion
            HttpSession session = req.getSession();
            Carro carro;
            if (session.getAttribute("carro") == null) {
                /*Obtenemso una nueva sesion*/
                carro = new Carro();
                //Seteamos los atributos
                session.setAttribute("carro", carro);
            }else{
                /*Seteamos los valores obtenidos del atributo*/
                carro = (Carro) session.getAttribute("carro");
            }
            carro.additemCarro(item);
        }
        resp.sendRedirect(req.getContextPath()+"/ver-carro");
    }
}
