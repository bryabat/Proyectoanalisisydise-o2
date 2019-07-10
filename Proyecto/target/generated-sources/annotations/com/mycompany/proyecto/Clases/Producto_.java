package com.mycompany.proyecto.Clases;

import com.mycompany.proyecto.Clases.Detallecompras;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2019-07-09T22:37:52", comments="EclipseLink-2.7.4.v20190115-rNA")
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