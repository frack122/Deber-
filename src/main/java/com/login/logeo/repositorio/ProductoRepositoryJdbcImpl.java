package com.login.logeo.repositorio;

import com.login.logeo.controlers.ActivarProducto;
import com.login.logeo.models.Producto1;

import java.sql.*;

import com.login.logeo.models.Categoria;

import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryJdbcImpl implements Repository<Producto1> {
    private Connection connection;

    public ProductoRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Producto1> list() throws SQLException {
        List<Producto1> productos = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM articulo ")) {
            while (rs.next()) {
                Producto1 producto = getProducto1(rs);
                productos.add(producto);
            }
        }

        return productos;
    }

    @Override
    public Producto1 porID(Integer id) throws SQLException {
      Producto1 producto = null;
      try (PreparedStatement stmt = connection.prepareStatement("select p.*,categoria.cat_nopmbre from articulo as p INNER JOIN categoria  on categoria.id_cat = p.art_estado WHERE p.id_art=?;")) {
         stmt.setInt(1, id);
         try (ResultSet rs = stmt.executeQuery()) {
             if (rs.next()) {
                 producto = getProducto1(rs);
             }
         }

      }
        return producto;
    }

    @Override
    public void guardar(Producto1 producto1) throws SQLException {
        String sql;
        if (producto1.getId() != null && producto1.getId() > 0) {
            sql = "UPDATE articulo SET art_nombre ?, art_descripcion ?, art_precio ?, id_cat,art_estado=? = ? WHERE id_cat = ?";
        }else {
            sql = "INSERT INTO articulo (art_nombre, art_descripcion, art_precio, id_cat,art_estado) VALUES(?,?,?,?,?) )";
        }
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, producto1.getNombre());
            stmt.setInt(2, producto1.getCategoria().getIdCategoria());
            stmt.setString(3, producto1.getDescripcion());
            stmt.setDouble(4, producto1.getPrecio());
            if (producto1.getId() != null && producto1.getId() > 0)
            {
                stmt.setInt(5, producto1.getId());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        String sql = "DELETE FROM producto WHERE id_cat = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Producto1 activar(Integer id) throws SQLException {
        return null;
    }

    @Override
    public Producto1 desactivar(Integer id) throws SQLException {
        return null;
    }

    private static Producto1 getProducto1(ResultSet rs) throws SQLException {
        Producto1 producto = new Producto1();
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(rs.getInt("id_cat"));
        if (categoria == null) {
            categoria = new Categoria();
            categoria.setIdCategoria(rs.getInt("id_cat"));
        }else {
            producto.setCategoria(categoria);
        }
       if  (producto==null){
               producto= new Producto1();
               producto.setId(rs.getInt("id_art"));
               producto.setNombre(rs.getString("art_nombre"));
               producto.setDescripcion(rs.getString("art_descripcion"));
               producto.setPrecio(rs.getDouble("art_precio"));
               producto.setStock(rs.getInt("art_stock"));
       }else {
           producto.setId(rs.getInt("id_art"));
           producto.setNombre(rs.getString("art_nombre"));
           producto.setDescripcion(rs.getString("art_descripcion"));
           producto.setPrecio(rs.getDouble("art_precio"));
           producto.setStock(rs.getInt("art_stock"));

       }
        return producto;
    }
}
