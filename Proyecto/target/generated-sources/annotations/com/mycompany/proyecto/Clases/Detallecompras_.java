package com.mycompany.proyecto.Clases;

import com.mycompany.proyecto.Clases.Compras;
import com.mycompany.proyecto.Clases.Devoluciones;
import com.mycompany.proyecto.Clases.Producto;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2019-07-09T22:37:52", comments="EclipseLink-2.7.4.v20190115-rNA")
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