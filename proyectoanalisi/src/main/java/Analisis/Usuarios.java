package Analisis;

import com.mycompany.proyectoanalisi.base.Usuario;
import com.mycompany.proyectoanalisi.base.UsuarioJpaController;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Usuarios {

  private static Usuarios usuario=null;

  public static Usuarios usuarioInstancia() {
      if (Usuarios.usuario==null) {
          Usuarios.usuario=new Usuarios();
      }
      return Usuarios.usuario;
  }
    public void Inicio(String nombre,String contrasenia,Servidor servidor){
        int aux=0;
        EntityManager mn= servidor.getEm();
        TypedQuery<Usuario> query=mn.createNamedQuery("Usuario.findAll", Usuario.class);
        List<Usuario> listaProductos=query.getResultList();
        for (Usuario usuario : listaProductos) {
            if (usuario.getUsuario().equals(nombre)&& usuario.getContrasenia().equals(contrasenia)) {
                System.out.println("Inicio correcto");
            }
        }
        
    }
}