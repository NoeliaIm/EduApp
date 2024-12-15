package com.niglesiasm.eduapp.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alumno_ambito", schema = "eduapp")
public class AlumnoAmbito {
    @EmbeddedId
    private AlumnoAmbitoId id;

}