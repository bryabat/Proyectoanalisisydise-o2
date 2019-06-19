package javaapplication31;

import java.util.Vector;

public class Servidor {

  private static Servidor unicoservidor=null;

  
  public static Servidor nuevaInstacia() {
      if (Servidor.unicoservidor==null) {
          Servidor.unicoservidor=new Servidor();
      }
      return Servidor.unicoservidor;
  }


}