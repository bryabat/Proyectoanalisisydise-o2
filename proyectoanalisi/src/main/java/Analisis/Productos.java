package Analisis;

import com.mycompany.proyectoanalisi.base.Producto;
import com.mycompany.proyectoanalisi.base.ProductoJpaController;
import java.util.Vector;

public class Productos extends Pedido {

  private String nombre;

  private Float precio;

  private String marca;

  private ProductoJpaController jpaController;
          
  public Vector  myPedido;
  
    public Productos(Servidor ser){
        jpaController=new ProductoJpaController(ser.getMp());
    }
    public void nuevoProducto(){
        Producto producto= new Producto(); 
        jpaController.create(producto);  
    }

  public void eliminarProducto() {
      
  }

  public void consultarExistencia() {
      
      
  }


}