package com.mycompany.proyectoanalisi.base;

import com.mycompany.proyectoanalisi.base.Detallecompras;
import com.mycompany.proyectoanalisi.base.Proveedor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2019-07-08T17:42:53")
@StaticMetamodel(Compras.class)
public class Compras_ { 

    public static volatile SingularAttribute<Compras, Date> fecha;
    public static volatile SingularAttribute<Compras, Integer> total;
    public static volatile SingularAttribute<Compras, Integer> idcompras;
    public static volatile SingularAttribute<Compras, Proveedor> proveedorIdproveedor;
    public static volatile CollectionAttribute<Compras, Detallecompras> detallecomprasCollection;

}