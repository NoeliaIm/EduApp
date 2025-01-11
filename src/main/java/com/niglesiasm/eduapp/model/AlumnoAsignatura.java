package com.niglesiasm.eduapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alumno_asignatura", schema = "eduapp")
public class AlumnoAsignatura {
    @EmbeddedId
    private AlumnoAsignaturaId id;

    @Column(name = "contador")
    private Integer contador = 0;

    public void incrementarContador() {
        this.contador = (this.contador == null) ? 1 : this.contador + 1;
    }
}