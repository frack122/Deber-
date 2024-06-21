package com.login.logeo.repositorio;

import com.login.logeo.models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriarepositoryImplemet implements Repository<Categoria>{

    private Connection connection;

    public CategoriarepositoryImplemet(Connection connection) {
        this.connection = connection;
    }


    @Override
    public List<Categoria> list() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try(Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from categoria");){
            while(rs.next()){
                Categoria categoria = getCategoria(rs);
                categorias.add(categoria);
            }

        }
        return categorias;
    }

    @Override
    public Categoria porID(Integer id) throws SQLException {
       Categoria categoria = null;
       try(PreparedStatement stmt = connection.prepareStatement("select * from categoria where id_cat = ?");){
           stmt.setInt(1, id);
           try(ResultSet rs = stmt.executeQuery()){
               if(rs.next()){
                   categoria = getCategoria(rs);
               }
           }
       }
       return categoria;
    }

    @Override
    public void guardar(Categoria categoria) throws SQLException {

    }

    @Override
    public void eliminar(Integer id) throws SQLException {

    }

    @Override
    public Categoria activar(Integer id) throws SQLException {
        return null;
    }

    @Override
    public Categoria desactivar(Integer id) throws SQLException {
        return null;
    }

    private Categoria getCategoria(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setNombre(rs.getString("cat_nopmbre"));
        categoria.setIdCategoria(rs.getInt("id_cat"));
        return categoria;
    }
}
