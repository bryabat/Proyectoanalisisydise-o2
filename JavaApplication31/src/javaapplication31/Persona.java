package javaapplication31;

import java.util.Date;
import java.util.Vector;

public class Persona {

  private String nombre;

  private Date fecha_nacimiento;

  private String telefono;

  private String direccion;

    public Vector  myUsuario;
    public Vector  myProveedor;

  public void Cambionombre() {
  }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Vector getMyUsuario() {
        return myUsuario;
    }

    public void setMyUsuario(Vector myUsuario) {
        this.myUsuario = myUsuario;
    }

    public Vector getMyProveedor() {
        return myProveedor;
    }

    public void setMyProveedor(Vector myProveedor) {
        this.myProveedor = myProveedor;
    }

}