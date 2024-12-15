package com.niglesiasm.eduapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "anios_academicos", schema = "eduapp")
public class AnnioAcademico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anio", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "descripcion", nullable = false, length = 20)
    private String descripcion;

    @NotNull
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fecha_inicio;

    @NotNull
    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fecha_fin;

    @Column(name = "activo")
    private Boolean activo;

}