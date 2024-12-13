package com.niglesiasm.eduapp.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    @NotNull
    @Column(name = "numero_expediente", nullable = false)
    private Long numeroExpediente;
    

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_nacionalidad")
    private Nacionalidad nacionalidad;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "alumno_asignatura",
            joinColumns = @JoinColumn(name = "id_alumno"),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura"))
    private Set<Asignatura> asignaturas = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "alumno_idioma",
            joinColumns = @JoinColumn(name = "id_alumno"),
            inverseJoinColumns = @JoinColumn(name = "id_idioma"))
    private Set<Idioma> idiomas = new LinkedHashSet<>();


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "alumno_necesidad", joinColumns = @JoinColumn(name = "id_alumno"))
    @Column(name = "id_necesidad")
    @Convert(converter = NecesidadEspecial.NEConverter.class)
    private Set<NecesidadEspecial> necesidadesEspeciales = new HashSet<>();


    @JsonManagedReference
    @OneToMany(mappedBy = "alumno")
    private Set<AlumnoAmbito> ambitos = new HashSet<>();


}