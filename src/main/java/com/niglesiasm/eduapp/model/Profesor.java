package com.niglesiasm.eduapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "profesores", schema = "eduapp")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @ManyToMany
    @JoinTable(
            name = "profesor_asignatura", // Nombre de la tabla intermedia en la base de datos
            joinColumns = @JoinColumn(name = "id_profesor"), // Llave foránea de tabla Profesor
            inverseJoinColumns = @JoinColumn(name = "id_asignatura") // Llave foránea de tabla Asignatura
    )
    private List<Asignatura> asignaturas;

}