/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Clases;

import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author EQUIPO
 */
public class Productos {
    private Vector<String> nombre;
    private Vector<Integer> existencia;
    private Vector<Double> precioEntrada;
    private Vector<Double> precioSalida;
    public void Ingresar(String nombre,Integer existencia,Double precioEntrada, Double precioSalida){
        this.nombre.add(nombre);
        this.existencia.add(existencia);
        this.precioEntrada.add(precioEntrada);
        this.precioSalida.add(precioSalida);
    }

    public Productos() {
        nombre=new Vector<>();
        existencia=new Vector<>();
        precioEntrada=new Vector<>();
        precioSalida=new Vector<>();
    }
       
    public Vector<String> getNombre() {
        return nombre;
    }

    public Vector<Integer> getExistencia() {
        return existencia;
    }

    public Vector<Double> getPrecioEntrada() {
        return precioEntrada;
    }

    public Vector<Double> getPrecioSalida() {
        return precioSalida;
    }
    
}
