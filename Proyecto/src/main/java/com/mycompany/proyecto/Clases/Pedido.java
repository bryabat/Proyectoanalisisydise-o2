/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Clases;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author EQUIPO
 */
public class Pedido {
    private Proveedor proveedor=null;
    private Compras compras=null;
    private ArrayList<Producto> productos;
    public Pedido(){
        productos=new ArrayList<>();
    }
    public void agregar(Producto producto){
        this.productos.add(producto);
    }

    public Proveedor getProveedor() {
        return proveedor;
    }
    

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public void busqueda(String nombre, Servidor servidor){
        EntityManager mn= servidor.getEm();
        TypedQuery<Proveedor> query=mn.createNamedQuery("Proveedor.findAll", Proveedor.class);
        List<Proveedor> listaProductos=query.getResultList();
        for (Proveedor proveedor : listaProductos) {
            if (proveedor.getNombre().equals(nombre)) {
                this.proveedor = proveedor;
            }
        }
    }
    
        public Producto busquedaProducto(Servidor servidor,String nombre){
        EntityManager mn= servidor.getEm();
        TypedQuery<Producto> query=mn.createNamedQuery("Producto.findAll", Producto.class);
        List<Producto> listaProductos=query.getResultList();
        for (Producto producto : listaProductos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }
}
