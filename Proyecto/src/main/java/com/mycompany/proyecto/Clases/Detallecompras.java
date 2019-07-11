/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto.Clases;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author EQUIPO
 */
@Entity
@Table(name = "detallecompras")
@NamedQueries({
    @NamedQuery(name = "Detallecompras.findAll", query = "SELECT d FROM Detallecompras d"),
    @NamedQuery(name = "Detallecompras.findById", query = "SELECT d FROM Detallecompras d WHERE d.id = :id"),
    @NamedQuery(name = "Detallecompras.findBySubtotal", query = "SELECT d FROM Detallecompras d WHERE d.subtotal = :subtotal"),
    @NamedQuery(name = "Detallecompras.findByCantidad", query = "SELECT d FROM Detallecompras d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Detallecompras.findByDescuento", query = "SELECT d FROM Detallecompras d WHERE d.descuento = :descuento")})
public class Detallecompras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subtotal")
    private Double subtotal;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "descuento")
    private Double descuento;
    @JoinColumn(name = "compras_idcompras", referencedColumnName = "idcompras")
    @ManyToOne(optional = false)
    private Compras comprasIdcompras;
    @JoinColumn(name = "producto_idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto productoIdproducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detallecomprasId")
    private Collection<Devoluciones> devolucionesCollection;

    public Detallecompras() {
    }

    public Detallecompras(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Compras getComprasIdcompras() {
        return comprasIdcompras;
    }

    public void setComprasIdcompras(Compras comprasIdcompras) {
        this.comprasIdcompras = comprasIdcompras;
    }

    public Producto getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Producto productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    public Collection<Devoluciones> getDevolucionesCollection() {
        return devolucionesCollection;
    }

    public void setDevolucionesCollection(Collection<Devoluciones> devolucionesCollection) {
        this.devolucionesCollection = devolucionesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallecompras)) {
            return false;
        }
        Detallecompras other = (Detallecompras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyecto.Clases.Detallecompras[ id=" + id + " ]";
    }
    
}
