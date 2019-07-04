package javaapplication31;

import java.util.Vector;

public class Productos extends Pedido {

  private String nombre;

  private Float precio;

  private String marca;

  public Vector  myPedido;
  
  public void productos() {
      
  }

  public void eliminarProducto() {
  }

  public void consultarExistencia() {
  }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Vector getMyPedido() {
        return myPedido;
    }

    public void setMyPedido(Vector myPedido) {
        this.myPedido = myPedido;
    }

}   