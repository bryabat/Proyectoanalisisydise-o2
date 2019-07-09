package com.mycompany.proyectoanalisi.base;

import com.mycompany.proyectoanalisi.base.Compras;
import com.mycompany.proyectoanalisi.base.Devoluciones;
import com.mycompany.proyectoanalisi.base.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-07-08T17:42:53")
@StaticMetamodel(Detallecompras.class)
public class Detallecompras_ { 

    public static volatile CollectionAttribute<Detallecompras, Devoluciones> devolucionesCollection;
    public static volatile SingularAttribute<Detallecompras, Double> subtotal;
    public static volatile SingularAttribute<Detallecompras, Double> descuento;
    public static volatile SingularAttribute<Detallecompras, Compras> comprasIdcompras;
    public static volatile SingularAttribute<Detallecompras, Integer> id;
    public static volatile SingularAttribute<Detallecompras, Integer> cantidad;
    public static volatile SingularAttribute<Detallecompras, Producto> productoIdproducto;

}