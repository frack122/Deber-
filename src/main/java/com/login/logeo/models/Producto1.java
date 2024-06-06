package com.login.logeo.models;

public class Producto1 {

    private int id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private double precio;

    public Producto1(){}
   /*No podemos tener dos constructores vacio por que es sobrecarga de metodos*/
    public Producto1(int id, String nombre, String descripcion, String categoria, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
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
    public double getPrecio() {return precio;}
    public void setPrecio(double precio) {}
}
/*Debe tener 4 parametros id,nombre,categoria.descripcion
 * debe tener un constructor vacio
 * y uno que inicialize los parametros , con get y set*/

/**/