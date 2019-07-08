/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoanalisi.base;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author EQUIPO
 */
@Entity
@Table(name = "devoluciones")
@NamedQueries({
    @NamedQuery(name = "Devoluciones.findAll", query = "SELECT d FROM Devoluciones d"),
    @NamedQuery(name = "Devoluciones.findByIddevoluciones", query = "SELECT d FROM Devoluciones d WHERE d.iddevoluciones = :iddevoluciones"),
    @NamedQuery(name = "Devoluciones.findByCantidad", query = "SELECT d FROM Devoluciones d WHERE d.cantidad = :cantidad")})
public class Devoluciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddevoluciones")
    private Integer iddevoluciones;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "detallecompras_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Detallecompras detallecomprasId;

    public Devoluciones() {
    }

    public Devoluciones(Integer iddevoluciones) {
        this.iddevoluciones = iddevoluciones;
    }

    public Integer getIddevoluciones() {
        return iddevoluciones;
    }

    public void setIddevoluciones(Integer iddevoluciones) {
        this.iddevoluciones = iddevoluciones;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Detallecompras getDetallecomprasId() {
        return detallecomprasId;
    }

    public void setDetallecomprasId(Detallecompras detallecomprasId) {
        this.detallecomprasId = detallecomprasId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddevoluciones != null ? iddevoluciones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devoluciones)) {
            return false;
        }
        Devoluciones other = (Devoluciones) object;
        if ((this.iddevoluciones == null && other.iddevoluciones != null) || (this.iddevoluciones != null && !this.iddevoluciones.equals(other.iddevoluciones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectoanalisi.base.Devoluciones[ iddevoluciones=" + iddevoluciones + " ]";
    }
    
}
