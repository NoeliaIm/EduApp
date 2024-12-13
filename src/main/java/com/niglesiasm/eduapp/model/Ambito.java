package com.niglesiasm.eduapp.model;

import jakarta.persistence.*;


@Entity
@Table(name = "ambitos_academicos")
public class Ambito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ambito")
    private Long id;

    @Column(nullable = false)
    private String nombre;
}

