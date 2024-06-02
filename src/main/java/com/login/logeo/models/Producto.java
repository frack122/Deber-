package com.login.logeo.models;


public class Producto  {

    protected int id;
    protected String nombre;
    protected String descripcion;
    protected String categoria;

    public Producto() {

    }
    public Producto(int id, String nombre, String descripcion, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
/*Debe tener 4 parametros id,nombre,categoria.descripcion
* debe tener un constructor vacio
* y uno que inicialize los parametros , con get y set*/

/**/