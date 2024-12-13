package com.niglesiasm.eduapp.model;

public enum Roles {

    ADMIN(1, "Administrador"),PROF(2, "Profesor"),ALUM(3, "Alumno");

    private int id;
    private String name;

    Roles(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
