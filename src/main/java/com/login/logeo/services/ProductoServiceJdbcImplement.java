package com.login.logeo.services;

import com.login.logeo.models.Categoria;
import com.login.logeo.models.Producto1;
import com.login.logeo.repositorio.CategoriarepositoryImplemet;
import com.login.logeo.repositorio.ProductoRepositoryJdbcImpl;
import com.login.logeo.repositorio.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductoServiceJdbcImplement implements ProductoService{
    
    private Repository <Producto1> repositoryJdbc;
    private Repository <Categoria> categoriaRepository;
    
    public ProductoServiceJdbcImplement(Connection connection) {
        this.repositoryJdbc = new ProductoRepositoryJdbcImpl(connection);
        this.categoriaRepository= new CategoriarepositoryImplemet(connection);
    }
    /*Implementamos los metdos */
    @Override
    public List<Producto1> listar() throws ServiceJdbcException {
        try{
            return repositoryJdbc.list();
        }catch (SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
    @Override
    public void guardar(Producto1 producto) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Categoria> listarCategorias() {
       try {
           return categoriaRepository.list();
       }catch (SQLException throwables){
           throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
       }
    }

    @Override
    public Optional<Categoria> porIdCategoria(Integer id) {
        try{
            return Optional.ofNullable(categoriaRepository.porID(id));
        }catch (SQLException throwables){
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }

    @Override
    public Optional<Producto1> porId(Integer id) {

       try{
           return Optional.ofNullable(repositoryJdbc.porID(id));
       }catch (SQLException throwables){
           throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
       }
    }
    
    
}
