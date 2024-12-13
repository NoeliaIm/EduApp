package com.niglesiasm.eduapp.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.Getter;

@Getter
public enum NombresCursos {
    ESO1(1, "1º ESO"), ESO2(2, "2º ESO"), ESO3(3, "3º ESO"), ESO4(4, "4º ESO");

    private int id;
    private String nombre;

    NombresCursos(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public static NombresCursos fromId(int id) {
        for (NombresCursos nombresCursos : values()) {
            if (nombresCursos.id == id) {
                return nombresCursos;
            }
        }
        throw new IllegalArgumentException("Invalid Rol id: " + id);
    }

    public static NombresCursos fromName(String name) {
        for (NombresCursos nombresCursos : values()) {
            if (nombresCursos.nombre.equalsIgnoreCase(name)) {
                return nombresCursos;
            }
        }
        throw new IllegalArgumentException("Invalid nombreCurso name: " + name);
    }

    // Converter para JPA
    @Converter(autoApply = true)
    public static class NombreCursoConverter implements AttributeConverter<NombresCursos, Integer> {
        @Override
        public Integer convertToDatabaseColumn(NombresCursos nombresCursos) {
            return nombresCursos != null ? nombresCursos.getId() : null;
        }

        @Override
        public NombresCursos convertToEntityAttribute(Integer id) {
            return id != null ? NombresCursos.fromId(id) : null;
        }
    }
}
