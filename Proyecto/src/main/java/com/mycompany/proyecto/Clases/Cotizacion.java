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
public class Cotizacion {
    public Proveedor proveedor;
    public List<Producto> listaproList;
    public void agregar(Producto producto){
        this.listaproList.add(producto);
    }

    public List<Producto> getProductos() {
        return listaproList;
    }
}
