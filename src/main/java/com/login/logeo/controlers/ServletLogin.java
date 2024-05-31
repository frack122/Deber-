package com.login.logeo.controlers;

import com.login.logeo.services.LoginService;
import com.login.logeo.services.LoginServiceImplement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

/*Creaamos el Path para la conexion al Servlet*/
@WebServlet({"/Login","/ServletLogin"})
public class ServletLogin extends HttpServlet {

    final static String USUARIO = "admin";
    final static String PASSWORD = "admin";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceImplement();
        Optional <String> usernameOptional = auth.getUserName(req);
        if (usernameOptional.isPresent()) {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
               out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Bienvenido al Sistema  :"+usernameOptional.get()+",Has Iniciado con exito </h1>");
                out.println("<p><a href='"+req.getContextPath()+"/index.html'>volver</a></p>");
                out.println("<p><a href='"+req.getContextPath()+"/logout'>Cerrar session</a></p>");
                out.println("</body>");
                out.println("</html>");
            }
        }else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
    //Sobrescribos , obtenemops el dato del formulario
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        /*Hacemos una compaaracion*/
        if(USUARIO.equals(username) && PASSWORD.equals(password)) {
            /*Si esto se cumple nos direcciona a una pagina
            * Obtengo o genero la sesion
            * y seteamos los atributos*/
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            /*Obtenemmos los parametros de get ´path
            * Para dirigirnos ServletLogin*/
            resp.sendRedirect(req.getContextPath()+"/ServletLogin");
        }else{
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"No esta autorizado al sistema");
        }
    }
}
