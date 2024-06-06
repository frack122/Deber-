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
import java.util.Optional;

/*Aqui llamamos a nuestra llave*/
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginService auth = new LoginServiceImplement();
        Optional<String>username=auth.getUserName(request);
        if(username.isPresent()) {
            HttpSession session=request.getSession();
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath()+"/ServletLogin");
    }
}
