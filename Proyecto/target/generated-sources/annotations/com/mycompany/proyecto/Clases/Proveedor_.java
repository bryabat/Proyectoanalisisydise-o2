package com.mycompany.proyecto.Clases;

import com.mycompany.proyecto.Clases.Compras;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2019-07-09T22:37:52", comments="EclipseLink-2.7.4.v20190115-rNA")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, Integer> idproveedor;
    public static volatile CollectionAttribute<Proveedor, Compras> comprasCollection;
    public static volatile SingularAttribute<Proveedor, String> correo;
    public static volatile SingularAttribute<Proveedor, String> nit;
    public static volatile SingularAttribute<Proveedor, String> direccion;
    public static volatile SingularAttribute<Proveedor, String> telefono;
    public static volatile SingularAttribute<Proveedor, String> nombre;

}