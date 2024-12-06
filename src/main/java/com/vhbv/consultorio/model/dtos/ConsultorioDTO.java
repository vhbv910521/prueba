package com.vhbv.consultorio.model.dtos;

public class ConsultorioDTO extends BaseDTO {
    private Long id;
    private String numero;
    private String piso;

    public ConsultorioDTO(String numero, String piso) {
        this.numero = numero;
        this.piso = piso;
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
