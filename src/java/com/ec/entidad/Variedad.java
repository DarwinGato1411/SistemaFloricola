/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Darwin
 */
@Entity
@Table(name = "variedad")
public class Variedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_variedad")
    private Integer idVariedad;
    @Column(name = "var_nombre")
    private String varNombre;
    @Column(name = "var_codigo")
    private String varCodigo;
    @Column(name = "var_principal")
    private Boolean varPrincipal;
    @OneToMany(mappedBy = "idVariedad")
    private Collection<Producto> productoCollection;

    public Variedad() {
    }

    public Variedad(Integer idVariedad) {
        this.idVariedad = idVariedad;
    }

    public Integer getIdVariedad() {
        return idVariedad;
    }

    public void setIdVariedad(Integer idVariedad) {
        this.idVariedad = idVariedad;
    }

    public String getVarNombre() {
        return varNombre;
    }

    public void setVarNombre(String varNombre) {
        this.varNombre = varNombre;
    }

    public String getVarCodigo() {
        return varCodigo;
    }

    public void setVarCodigo(String varCodigo) {
        this.varCodigo = varCodigo;
    }

    public Boolean getVarPrincipal() {
        return varPrincipal;
    }

    public void setVarPrincipal(Boolean varPrincipal) {
        this.varPrincipal = varPrincipal;
    }

    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVariedad != null ? idVariedad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Variedad)) {
            return false;
        }
        Variedad other = (Variedad) object;
        if ((this.idVariedad == null && other.idVariedad != null) || (this.idVariedad != null && !this.idVariedad.equals(other.idVariedad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ec.entidades.Variedad[ idVariedad=" + idVariedad + " ]";
    }

}
