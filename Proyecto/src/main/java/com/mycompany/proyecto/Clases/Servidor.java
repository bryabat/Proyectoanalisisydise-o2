/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Clases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author EQUIPO
 */
public class Servidor {
    
  private static Servidor unicoservidor=null;
  private EntityManagerFactory mp=null;
  private EntityManager em=null;

    public EntityManagerFactory getMp() {
        return mp;
    }

    public EntityManager getEm() {
        return em;
    }
  
  public static Servidor nuevaInstacia() {
      if (Servidor.unicoservidor==null) {
          Servidor.unicoservidor=new Servidor();          
      }
      return Servidor.unicoservidor;
  }
    public void conexion(){
        mp=Persistence.createEntityManagerFactory("ycomercial");
        em=mp.createEntityManager();
    }   
    public void desconexion(){
        em.close();
    }
   
}
