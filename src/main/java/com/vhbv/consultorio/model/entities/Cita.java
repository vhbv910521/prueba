package com.vhbv.consultorio.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Cita extends EntityBase {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JsonIgnoreProperties(value = "personas", allowSetters = true)
    private Doctor doctor;
    @ManyToOne
    @JsonIgnoreProperties(value = "personas", allowSetters = true)
    private Consultorio consultorio;
    @Basic
    private Timestamp horario;

    public Cita() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public Timestamp getHorario() {
        return horario;
    }

    public void setHorario(Timestamp horario) {
        this.horario = horario;
    }
}
