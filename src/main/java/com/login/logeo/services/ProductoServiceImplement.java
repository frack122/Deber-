package com.login.logeo.services;

import com.login.logeo.models.Producto1;

import java.util.Arrays;
import java.util.List;
/*Aqui obtenemos los parametros que se indicara en formulario desde mi interfaz de prueba*/
public class ProductoServiceImplement implements ProductoService {

    @Override
    public List<Producto1>listarPorCategoria(String categoria){
        return Arrays.asList(new Producto1(1,"Lapto","computacion","Hp 17",1000),
        new Producto1(2,"tv","entrenimiento","tv 17",1000),
        new Producto1(3,"Smartwatch","computacion","celular",155),
        new Producto1(4,"CompuES","Escritorio","Computacion",100));
    }
}
