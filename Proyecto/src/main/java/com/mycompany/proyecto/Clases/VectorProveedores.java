/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Clases;

import java.util.Vector;

/**
 *
 * @author EQUIPO
 */
public class VectorProveedores {
    private Vector<String> nombre;
    private Vector<String> direccion;
    private Vector<String> telefono;

    public Vector<String> getNombre() {
        return nombre;
    }

    public Vector<String> getDireccion() {
        return direccion;
    }

    public Vector<String> getTelefono() {
        return telefono;
    }

    public VectorProveedores() {
        nombre=new Vector<>();
        direccion=new Vector<>();
        telefono=new Vector<>();
    }
    public void ingreso(String nombre,String direccion,String telefono){
        this.nombre.add(nombre);
        this.direccion.add(direccion);
        this.telefono.add(telefono);
    }
}
