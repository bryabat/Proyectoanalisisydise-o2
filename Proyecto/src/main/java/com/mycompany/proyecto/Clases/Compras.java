/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Clases;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "compras")
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findByIdcompras", query = "SELECT c FROM Compras c WHERE c.idcompras = :idcompras"),
    @NamedQuery(name = "Compras.findByFecha", query = "SELECT c FROM Compras c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Compras.findByTotal", query = "SELECT c FROM Compras c WHERE c.total = :total")})
public class Compras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcompras")
    private Integer idcompras;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "total")
    private Integer total;
    @JoinColumn(name = "proveedor_idproveedor", referencedColumnName = "idproveedor")
    @ManyToOne(optional = false)
    private Proveedor proveedorIdproveedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comprasIdcompras")
    private Collection<Detallecompras> detallecomprasCollection;

    public Compras() {
    }

    public Compras(Integer idcompras) {
        this.idcompras = idcompras;
    }

    public Integer getIdcompras() {
        return idcompras;
    }

    public void setIdcompras(Integer idcompras) {
        this.idcompras = idcompras;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Proveedor getProveedorIdproveedor() {
        return proveedorIdproveedor;
    }

    public void setProveedorIdproveedor(Proveedor proveedorIdproveedor) {
        this.proveedorIdproveedor = proveedorIdproveedor;
    }

    public Collection<Detallecompras> getDetallecomprasCollection() {
        return detallecomprasCollection;
    }

    public void setDetallecomprasCollection(Collection<Detallecompras> detallecomprasCollection) {
        this.detallecomprasCollection = detallecomprasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompras != null ? idcompras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.idcompras == null && other.idcompras != null) || (this.idcompras != null && !this.idcompras.equals(other.idcompras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyecto.Clases.Compras[ idcompras=" + idcompras + " ]";
    }
    
}
