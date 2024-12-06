package com.vhbv.consultorio.model.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Consultorio extends EntityBase {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String numero;
    @Basic
    private String piso;

    public Consultorio(Long id, String numero, String piso) {
        this.id = id;
        this.numero = numero;
        this.piso = piso;
    }

    public Consultorio(String numero, String piso) {
        this.numero = numero;
        this.piso = piso;
    }

    public Consultorio() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }
}
