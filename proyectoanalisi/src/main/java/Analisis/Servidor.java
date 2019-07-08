package Analisis;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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