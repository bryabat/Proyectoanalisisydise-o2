/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Clases;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author EQUIPO
 */
public class Usuarios {
     private static Usuarios usuario=null;

  public static Usuarios usuarioInstancia() {
      if (Usuarios.usuario==null) {
          Usuarios.usuario=new Usuarios();
      }
      return Usuarios.usuario;
  }
    public boolean Inicio(String nombre,String contrasenia,Servidor servidor){
        EntityManager mn= servidor.getEm();
        TypedQuery<Usuario> query=mn.createNamedQuery("Usuario.findAll", Usuario.class);
        List<Usuario> listaProductos=query.getResultList();
        for (Usuario usuario : listaProductos) {
            if (usuario.getUsuario().equals(nombre)&& usuario.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
        return false;
    }
}
