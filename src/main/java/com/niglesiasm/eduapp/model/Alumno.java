package com.niglesiasm.eduapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "alumnos", schema = "eduapp")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "numero_expediente", nullable = false)
    private Long numero_expediente;

}