package Analisis;

import java.util.Vector;

public class Usuario {

  private static Usuario usuario=null;

  public static Usuario usuarioInstancia() {
      if (Usuario.usuario==null) {
          Usuario.usuario=new Usuario();
      }
      return Usuario.usuario;
  }
    public void Inicio(String nombre,String contrasenia){
  
    }
}