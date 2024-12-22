package com.niglesiasm.eduapp.model;

import jakarta.persistence.*;
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
    private Boolean esNativo = false;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER) // Carga inmediata del nivel de idioma
    @JoinColumn(name = "id_nivel", nullable = false) // Relación con la tabla "niveles_idioma"
    private NivelIdioma nivelIdioma;

}