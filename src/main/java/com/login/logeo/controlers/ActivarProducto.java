package com.login.logeo.controlers;

import com.login.logeo.models.Producto1;
import com.login.logeo.services.*;
import com.login.logeo.util.test;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet("/Activar")
public class ActivarProducto extends HttpServlet {
    private Connection connection;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String mensaje="";
        int id;
        try {
            id=Integer.parseInt(request.getParameter("id"));
        }catch(NumberFormatException e){
            mensaje="El id del producto no es valido";
            request.setAttribute("mensaje",mensaje);
            request.getRequestDispatcher("index.html").forward(request, response);
            return;
        }
        Connection conn =(Connection) request.getAttribute("conn");
        if(conn==null){
            mensaje="No se puede activar el producto : conexion no valido";
            request.setAttribute("mensaje",mensaje);
            request.getRequestDispatcher("index.html").forward(request, response);
        }
        try{
               String sql = "Select art_stock from articulo where id_art=? ";
               try(PreparedStatement ps = conn.prepareStatement(sql)){
                   ps.setInt(1,id);
                   try(ResultSet rs = ps.executeQuery()){
                       if(rs.next()){
                           int  cantidad = Integer.parseInt(request.getParameter("cantidad"));;
                           int stock = rs.getInt("art_stock");
                           if(cantidad>stock){
                               String insersion = "UPDATE articulo SET art_stock = art_stock + ? where id_art = ?";
                               try(PreparedStatement pst = conn.prepareStatement(insersion)){
                                   pst.setInt(1,cantidad);
                                   pst.setInt(2,id);
                                   pst.executeUpdate();
                                   mensaje="Se ha insertado mas articulos al stock";
                               }
                           }else {
                               mensaje="NO se ha insercionado nada por que no cumple";
                           }
                       }else{
                           mensaje= "NO se ha encontrado la id que ha ingresado";
                       }
                   }
               }

        }catch (SQLException e){
            e.printStackTrace();
            mensaje="No se puede activar el producto";
        }
        request.setAttribute("mensaje",mensaje);
        request.getRequestDispatcher("index.html").forward(request, response);
    }
}
