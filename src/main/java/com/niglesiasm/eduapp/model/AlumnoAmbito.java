package com.niglesiasm.eduapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alumno_ambito", schema = "eduapp")
public class AlumnoAmbito {
    @EmbeddedId
    private AlumnoAmbitoId id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER) // Carga inmediata del nivel de idioma
    @JoinColumn(name = "id_nivel", nullable = false) // Relación con la tabla "niveles_idioma"
    private NivelAcademico nivelAcademico;


}