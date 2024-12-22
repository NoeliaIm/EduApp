package com.niglesiasm.eduapp.service.curso;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CursoDTO {
    private Integer idCurso;
    private String nombreCurso;
    private String annio;
    private boolean activo;


    public void setAnnio(LocalDate fechaInicio, LocalDate fechaFin) {
        this.annio = fechaInicio.getYear() + " - " + fechaFin.getYear();
    }

}