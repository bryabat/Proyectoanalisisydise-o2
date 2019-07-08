/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author EQUIPO
 */
public class Proyectoanalisis2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Servidor ser = Servidor.nuevaInstacia();
    ser.conexion();
    ser.desconexion();
    }
    
}
