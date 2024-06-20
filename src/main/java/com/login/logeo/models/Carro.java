package com.login.logeo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {
    /*Creamos una variable en lo cual inicializamos
    * de productos comprados que va a estar en el carro*/

    private List<itemCarro> items;

    /*implementamos el construcot*/
    public Carro() {
        this.items = new ArrayList<>();
    }
    /*Implementamos un metodo para añadir los productos
    * ala lista o al carrito*/
    public void additemCarro(itemCarro item) {
        if(items.contains(item)){
            Optional<itemCarro>optionalItemCarro = items.stream()
                    .filter(i-> i.equals(item))
                    .findAny();
            if(optionalItemCarro.isPresent()){
                itemCarro i = optionalItemCarro.get();
                i.setCantidad(item.getCantidad()+1);
            }
        }else{
            this.items.add(item);
        }
    }
    public List<itemCarro> getItems() {
        return items;
    }
    public  double gettotal (){
        return items.stream().mapToDouble(itemCarro::getImporte).sum();
    }
}
