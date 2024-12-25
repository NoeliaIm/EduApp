package com.niglesiasm.eduapp.model;

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

}