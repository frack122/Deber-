package com.login.logeo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test
{
    /*Creamos un metod para tener una conexion
    * mediante el pool de conexion */
    private static String url ="jdbc:mysql://localhost:3306/comprarventa?serverTimezone=UTC";
    private static String user ="root";
    private static String password ="";
    /*Creo el metod para obtener la conexion*/
    public static Connection getConnection()throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }

}
