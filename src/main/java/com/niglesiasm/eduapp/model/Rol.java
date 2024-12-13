package com.niglesiasm.eduapp.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.Getter;

@Getter
public enum Rol {
    ADMIN(1, "Administrador"),
    PROF(2, "Profesor"),
    ALUM(3, "Alumno");

    private final int id;
    private final String name;

    Rol(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Rol fromId(int id) {
        for (Rol rol : values()) {
            if (rol.id == id) {
                return rol;
            }
        }
        throw new IllegalArgumentException("Invalid Rol id: " + id);
    }

    public static Rol fromName(String name) {
        for (Rol rol : values()) {
            if (rol.name.equalsIgnoreCase(name)) {
                return rol;
            }
        }
        throw new IllegalArgumentException("Invalid Rol name: " + name);
    }

    // Converter para JPA
    @Converter(autoApply = true)
    public static class RolConverter implements AttributeConverter<Rol, Integer> {
        @Override
        public Integer convertToDatabaseColumn(Rol rol) {
            return rol != null ? rol.getId() : null;
        }

        @Override
        public Rol convertToEntityAttribute(Integer id) {
            return id != null ? Rol.fromId(id) : null;
        }
    }
}