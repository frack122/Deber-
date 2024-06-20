package com.login.logeo.models;

public class Categoria {

    private Integer idCategoria;
    private String nombre;
    private int estado;

    public Categoria(){

    }
    public Categoria(Integer idCategoria, String nombre, int estado) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }


    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
