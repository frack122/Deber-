package com.login.logeo.controlers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /*Creamos a la sesion*/
        HttpSession session = request.getSession();
        /*Creamos una lista para el articulo y el valor*/
        List<String> articulo = (List<String>) session.getAttribute("Producto");
        List<String> valor = (List<String>) session.getAttribute("valor");
        List<Integer> cantidades = (List<Integer>) session.getAttribute("cantidad");
        /*Creamos una condicion para saber si esta en la lista */
        if(articulo==null){
            /*Inicializamos la Lista*/
            articulo = new ArrayList<>();
            session.setAttribute("articulo", articulo);
        }
        if(valor==null){           valor = new ArrayList<>();
            session.setAttribute("valor", valor);
        }
        if(cantidades==null){
            cantidades = new ArrayList<>();
            session.setAttribute("cantidad", cantidades);
        }
        /*Procesamos el nuevo articulo*/
        String articuloNuevo = request.getParameter("Producto");
        Double valorNuevo = Double.parseDouble(request.getParameter("valor"));
        Integer cantidadNuevo = (Integer) Integer.parseInt(request.getParameter("cantidad"));
        /*Vamos hacer un condicional para verificar
        * si el nuevo articulo esta vacioi
        * y que el articulo esta vacio*/
        if(articuloNuevo!=null  && !articuloNuevo.trim().equals(" ") &&valorNuevo!=0 && cantidadNuevo!=0){
            articulo.add(articuloNuevo);
            valor.add(String.valueOf((valorNuevo)));
            cantidades.add( cantidadNuevo);
            session.setAttribute("Producto", articulo);
            session.setAttribute("valor", valor);
            session.setAttribute("cantidad", cantidades);
        }
        /*Imprimimos la lista
        try() {
            out.println("<h1>Lista de Articulos</h1>");
            out.println("<br>");
            /*Vamos a traer la lista iterando todos los articulos*/
           /* for(String art: articulo){
                out.println(art);
            }
            out.println("<br>");
            for(Integer valor1: valores){
                out.println(valor1);
            }
            out.println("<br>");
            for(Integer valor2: cantidades){
                out.println(valor2);
            }
            */
            /*Calculamos*/
            double preciotota= (valorNuevo*cantidadNuevo);

;

            /*Imprimimos los valores*/
            List<String> ListaArticulo = new ArrayList<>();
            ListaArticulo.add(articuloNuevo);

            List<Double> ListaValor = new ArrayList<>();
            ListaValor.add (valorNuevo);
            List<Double>Listpreciotota = new ArrayList<>();
            Listpreciotota.add(preciotota);

            List<Integer> ListaValor2 = new ArrayList<>();
            ListaValor2.add( cantidadNuevo);

            List <Double>ListaprecioTotal = new ArrayList<>();
            ListaprecioTotal.add((double)preciotota);

            out.println("<br>");
            out.println("<h2>Lista de Articulos</h2>");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Factura</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; }");
        out.println(".container { max-width: 600px; margin: 50px auto; background-color: #fff; border-radius: 8px; padding: 20px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); }");
        out.println("h1, h2, p, th, td { color: #333; }");
        out.println("table { width: 100%; border-collapse: collapse; }");
        out.println("th, td { border: 1px solid #ddd; padding: 8px; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Factura</h1>");
        out.println("<table>");
        out.println("<tr>");
        double subtotal = 0;
        for(int i = 0; i < articulo.size(); i++) {
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Artículo</th>");
            out.println("<th>Valor Unitario</th>");
            out.println("<th>Cantidad</th>");
            out.println("<tr>");
            out.println("<td>" + articulo.get(i) + "</td>");
            out.println("<td>" + valor.get(i) + "</td>");
            out.println("<td>" + cantidades.get(i) + "</td>");
            double total = Double.parseDouble(valor.get(i)) * cantidades.get(i);
            subtotal += total;
            out.println("</tr>");
        }
        double subtototal1 = subtotal *0.15;
        double totalfinal=subtototal1+subtotal;
        out.println("</table>");
        out.println("</div>");
        out.println("<p> el subtotal del iva es : "+subtototal1);
        out.println("</p>");
        out.println("<p> el total a pagar es : "+totalfinal);
        out.println("</p>");
        out.println("<br>");
        out.println("<a href='index.html'>Ir al artículo</a>");
        out.println("</body>");
        out.println("</html>");

        }


        }




