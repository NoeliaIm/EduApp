package com.niglesiasm.eduapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "necesidades_especiales", schema = "eduapp")
public class NecesidadEspecial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_necesidad", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "descripcion", nullable = false, length = 20)
    private String descripcion;

}