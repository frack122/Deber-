package com.login.logeo.services;

import com.login.logeo.models.Producto1;

import java.util.List;

public interface ProductoService {

    List<Producto1>listarPorCategoria(String categoria);
}
