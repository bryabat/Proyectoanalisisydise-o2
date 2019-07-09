/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Clases;

import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author EQUIPO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Servidor servidor= Servidor.nuevaInstacia();
        servidor.conexion();
        Login log= new Login(servidor);
        log.setVisible(true);
        
//        
//        Productos producto= new Productos();
//        producto.setExistencia(12);
//        producto.setNombre("Refrigerdor");
//        producto.setPrecioEntrada(12.4);
//        producto.setPrecioSalida(15.9);
//        
//        Vector<String> productos= new Vector<>();
//        productos.add(producto.getNombre());
//        productos.add(producto.getNombre());
//        Vector<Integer> produ= new Vector<>();
//        produ.add(producto.getExistencia());
//        produ.add(producto.getExistencia());
//        ProxyInvetario modelo= new ProxyInvetario(productos,produ);
//        Tabla form= new Tabla(modelo);
//        form.setVisible(true);
    }
}
