package com.niglesiasm.eduapp.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alumno_necesidad", schema = "eduapp")
public class AlumnoNecesidad {
    @EmbeddedId
    private AlumnoNecesidadId id;

}