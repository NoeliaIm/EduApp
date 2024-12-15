package com.niglesiasm.eduapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alumno_idioma", schema = "eduapp")
public class AlumnoIdioma {
    @EmbeddedId
    private AlumnoIdiomaId id;

    @NotNull
    @Column(name = "es_nativo", nullable = false)
    private Boolean es_nativo = false;

}