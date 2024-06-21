package com.login.logeo.controlers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/eliminar")
public class Desactivar extends HttpServlet {

    private Connection con;
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
                        String delete ="delete from articulo where id_art=?";
                        try(PreparedStatement pst = conn.prepareStatement(delete)){
                            pst.setInt(1,id);
                            pst.executeUpdate();
                            ps.executeUpdate();
                            mensaje="Se ha eliminado el producto";
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
