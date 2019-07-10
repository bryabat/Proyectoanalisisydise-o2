package com.mycompany.proyecto.Clases;

import com.mycompany.proyecto.Clases.Detallecompras;
import com.mycompany.proyecto.Clases.Proveedor;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2019-07-09T22:37:52", comments="EclipseLink-2.7.4.v20190115-rNA")
@StaticMetamodel(Compras.class)
public class Compras_ { 

    public static volatile SingularAttribute<Compras, Date> fecha;
    public static volatile SingularAttribute<Compras, Integer> total;
    public static volatile SingularAttribute<Compras, Integer> idcompras;
    public static volatile SingularAttribute<Compras, Proveedor> proveedorIdproveedor;
    public static volatile CollectionAttribute<Compras, Detallecompras> detallecomprasCollection;

}