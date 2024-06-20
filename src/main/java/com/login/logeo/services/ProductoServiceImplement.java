package com.login.logeo.services;

import com.login.logeo.models.Producto1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*Aqui obtenemos los parametros que se indicara en formulario desde mi interfaz de prueba*/
public class ProductoServiceImplement implements ProductoService {


    @Override
    public List<Producto1>listar(){
        return Arrays.asList();
    }

    @Override
    public Optional<Producto1> porId(Integer id) {
        return listar().stream().filter(p->p.getId().equals(id)).findAny();
    }

    @Override
    public void guardar(Producto1 producto) {

    }

    @Override
    public void eliminar(Integer id) {

    }
}
