package com.login.logeo.services;

import com.login.logeo.models.Producto1;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto1>listar();
    /*Implementamos un metodo para obtener el producto por
    * ID*/
    Optional<Producto1> porId(Integer id);

    /*Metodo para guardar */
    void guardar(Producto1 producto);
    /*Metodo para eliminar*/
    void eliminar(Integer id);

}
