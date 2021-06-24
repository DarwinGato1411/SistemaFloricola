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
@Table(name = "medida")
public class Medida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medida")
    private Integer idMedida;
    @Column(name = "med_nombre")
    private String medNombre;
    @Column(name = "med_codigo")
    private String medCodigo;
    @Column(name = "med_principal")
    private Boolean medPrincipal;
    @OneToMany(mappedBy = "idMedida")
    private Collection<Producto> productoCollection;

    public Medida() {
    }

    public Integer getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Integer idMedida) {
        this.idMedida = idMedida;
    }

    public String getMedNombre() {
        return medNombre;
    }

    public void setMedNombre(String medNombre) {
        this.medNombre = medNombre;
    }

    public String getMedCodigo() {
        return medCodigo;
    }

    public void setMedCodigo(String medCodigo) {
        this.medCodigo = medCodigo;
    }

    public Boolean getMedPrincipal() {
        return medPrincipal;
    }

    public void setMedPrincipal(Boolean medPrincipal) {
        this.medPrincipal = medPrincipal;
    }

    public Collection<Producto> getProductoCollection() {
        return productoCollection;
    }

    public void setProductoCollection(Collection<Producto> productoCollection) {
        this.productoCollection = productoCollection;
    }

   
}
