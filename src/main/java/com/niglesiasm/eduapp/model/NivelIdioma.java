package com.niglesiasm.eduapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "niveles_idioma", schema = "eduapp")
public class NivelIdioma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel", nullable = false)
    private Integer id;

    @Size(max = 10)
    @NotNull
    @Column(name = "descripcion", nullable = false, length = 10)
    private String descripcion;

}