package com.niglesiasm.eduapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "calificaciones", schema = "eduapp")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_calificacion", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_asignatura", referencedColumnName = "id_asignatura")
    private Asignatura asignatura;

    @NotNull
    @Column(name = "calificacion", nullable = false, precision = 5, scale = 2)
    private BigDecimal calificacion;

    @Column(name = "fecha_registro")
    private Instant fecha_registro;

}