package com.login.logeo.models;


import java.util.Objects;

public class itemCarro {
    /*Declaramos las variable del item del carro */

    private int cantidad;
    private Producto1 producto1;
    /*Inicializamos el carrito vacio*/
    public itemCarro() {

    }
    /*Inicializamos el carrito con los productos*/
    public itemCarro(int cantidad, Producto1 producto1){
        this.cantidad = cantidad;
        this.producto1 = producto1;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto1 getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto1 producto1) {
        this.producto1 = producto1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        itemCarro itemCarro = (itemCarro) o;
        return Objects.equals(producto1.getId(),itemCarro.producto1.getId())
        && Objects.equals(producto1.getNombre(),itemCarro.producto1.getNombre());
    }



    public double getImporte(){
        return cantidad*producto1.getPrecio();
    }
}
