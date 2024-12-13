package com.niglesiasm.eduapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "alumno_ambito", schema = "eduapp")
@IdClass(AlumnoAmbitoId.class)
public class AlumnoAmbito {

    @Id
    @Column(name = "id_alumno")
    private Integer idAlumno;

    @Id
    @Column(name = "id_ambito")
    private Long idAmbito;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;


    @ManyToOne
    @JoinColumn(name = "id_ambito", nullable = false)
    private Ambito ambito;

    @Enumerated(EnumType.STRING)
    @Column(name = "id_nivel", nullable = false)
    private NivelAcademico nivelAcademico;
}