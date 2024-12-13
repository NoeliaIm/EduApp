package com.niglesiasm.eduapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cursos", schema = "eduapp")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso", nullable = false)
    private Integer id;

    @NotNull
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_anio", nullable = false)
    private AnnioAcademico idAnio;


    @NotNull
    @Column(name = "id_nombre", nullable = false)
    @Convert(converter = NombresCursos.NombreCursoConverter.class)
    private NombresCursos nombreCurso;


}