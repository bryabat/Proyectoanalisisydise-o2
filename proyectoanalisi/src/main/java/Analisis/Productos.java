package Analisis;

import com.mycompany.proyectoanalisi.base.Producto;
import com.mycompany.proyectoanalisi.base.ProductoJpaController;
import java.util.Date;
import java.util.Vector;

public class Productos extends Pedido {

  private String nombre;
  private Double precioEntrada;
  private Double precioSalida;
  private String marca;
  private ProductoJpaController jpaController;
  private Date fechaEntrada;
  private Date fechaSalida;
  private int Existencia;
  public Vector  myPedido;

    public Productos(String nombre,Servidor servidor,Double precioEntrada, Double precioSalida, String marca, Date fechaEntrada, Date fechaSalida, int Existencia) {
        this.nombre = nombre;
        this.precioEntrada = precioEntrada;
        this.precioSalida = precioSalida;
        this.marca = marca;
        this.jpaController = new ProductoJpaController(servidor.getMp());
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.Existencia = Existencia;

    }
    public Productos(){
        
    }
  
  public void nuevoProducto(){
        Producto producto= new Producto(); 
        producto.setMarca(marca);
        producto.setNombre(nombre);
        producto.setPrecioEntrada(precioEntrada);
        producto.setPrecioSalida(precioSalida);
        producto.setFechaEntrada(fechaEntrada);
        producto.setGarantia(fechaSalida);
        producto.setExistencia(Existencia);
        jpaController.create(producto);  
  }

  public void eliminarProducto() {
      
  }

  public void consultarExistencia() {
      
      
  }


}