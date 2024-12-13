package com.niglesiasm.eduapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alumno_idioma", schema = "eduapp")
public class AlumnoIdioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno_idioma", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_idioma", nullable = false)
    private Idioma idioma;

    @Enumerated(EnumType.STRING)
    @Column(name = "id_nivel", nullable = false)
    private NivelIdioma nivelIdioma;

    @Column(name = "es_nativo", nullable = false)
    private Boolean esNativo;
}