package com.login.logeo.filter;
import com.login.logeo.services.ServiceJdbcException;
import com.login.logeo.util.test;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebFilter("/*")
public class ConexionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try(Connection conn = test.getConnection() ) {
            if(conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            try {
                /*Punto de conexion para la restablecion*/
                request.setAttribute("conn", conn);
                chain.doFilter(request, response);
                conn.commit();
            }catch(SQLException | ServiceJdbcException e) {
                conn.rollback();
                ((HttpServletResponse)response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage());
                e.printStackTrace();
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al conectar con la base de datos");
        }
    }
}
