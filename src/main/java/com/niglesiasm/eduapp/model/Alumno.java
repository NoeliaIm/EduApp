package com.niglesiasm.eduapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

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
    private Long numeroExpediente;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_nacionalidad", nullable = false)
    private Nacionalidad nacionalidad;

    @ManyToMany
    @JoinTable(name = "alumno_asignatura",
            joinColumns = @JoinColumn(name = "id_alumno"),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura"))
    private Set<Asignatura> asignaturas = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(
            name = "alumno_necesidad",
            joinColumns = @JoinColumn(name = "id_alumno"),
            inverseJoinColumns = @JoinColumn(name = "id_necesidad")
    )
    private Set<NecesidadEspecial> necesidadesEspeciales = new LinkedHashSet<>();

    @OneToMany(mappedBy = "id.alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AlumnoIdioma> idiomas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "id.alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AlumnoAmbito> ambitos = new LinkedHashSet<>();

}