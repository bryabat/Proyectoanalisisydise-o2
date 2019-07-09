/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Clases;

import java.util.List;

/**
 *
 * @author EQUIPO
 */
public class Pedido {
    private Proveedor proveedor;
    private List<Productos> productos;
    public Pedido(Proveedor proveedor){
        this.proveedor=proveedor;
    }
    public void agregar(Productos producto){
        this.productos.add(producto);
    }

    public List<Productos> getProductos() {
        return productos;
    }
}
