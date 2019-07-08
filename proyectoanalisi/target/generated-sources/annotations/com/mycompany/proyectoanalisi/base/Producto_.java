package com.mycompany.proyectoanalisi.base;

import com.mycompany.proyectoanalisi.base.Detallecompras;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-07-08T17:33:32")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Integer> existencia;
    public static volatile SingularAttribute<Producto, String> marca;
    public static volatile SingularAttribute<Producto, Double> precioSalida;
    public static volatile SingularAttribute<Producto, Date> fechaEntrada;
    public static volatile SingularAttribute<Producto, Integer> idproducto;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile CollectionAttribute<Producto, Detallecompras> detallecomprasCollection;
    public static volatile SingularAttribute<Producto, Double> precioEntrada;
    public static volatile SingularAttribute<Producto, Date> garantia;

}