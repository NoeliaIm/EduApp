package com.niglesiasm.eduapp.model;

import com.niglesiasm.eduapp.model.enums.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "persona", schema = "eduapp")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 50)
    @NotNull
    @Column(name = "apellido1", nullable = false, length = 50)
    private String apellido1;

    @Size(max = 50)
    @Column(name = "apellido2", length = 50)
    private String apellido2;

    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @NotNull
    @Column(name = "fecha_alta", nullable = false)
    private LocalDate fecha_alta;

    @Column(name = "fecha_baja")
    private LocalDate fecha_baja;


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "persona_roles", joinColumns = @JoinColumn(name = "id_persona"))
    @Column(name = "id_role")
    @Convert(converter = Rol.RolConverter.class)
    private Set<Rol> roles = new HashSet<>();

}