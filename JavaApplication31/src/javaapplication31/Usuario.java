package javaapplication31;

import java.util.Vector;

public class Usuario extends Persona{

  private static Usuario usuario=null;

  public static Usuario usuarioInstancia() {
      if (Usuario.usuario==null) {
          Usuario.usuario=new Usuario();
      }
      return Usuario.usuario;
  }

}