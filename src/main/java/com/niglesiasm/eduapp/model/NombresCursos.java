package com.niglesiasm.eduapp.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.Getter;

@Getter
public enum NombreCurso {
    ESO1(1, "1º ESO"), ESO2(2, "2º ESO"), ESO3(3, "3º ESO"), ESO4(4, "4º ESO");

    private int id;
    private String nombre;

    NombreCurso(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public static NombreCurso fromId(int id) {
        for (NombreCurso nombreCurso : values()) {
            if (nombreCurso.id == id) {
                return nombreCurso;
            }
        }
        throw new IllegalArgumentException("Invalid Rol id: " + id);
    }

    public static NombreCurso fromName(String name) {
        for (NombreCurso nombreCurso : values()) {
            if (nombreCurso.nombre.equalsIgnoreCase(name)) {
                return nombreCurso;
            }
        }
        throw new IllegalArgumentException("Invalid nombreCurso name: " + name);
    }

    // Converter para JPA
    @Converter(autoApply = true)
    public static class NombreCursoConverter implements AttributeConverter<NombreCurso, Integer> {
        @Override
        public Integer convertToDatabaseColumn(NombreCurso nombreCurso) {
            return nombreCurso != null ? nombreCurso.getId() : null;
        }

        @Override
        public NombreCurso convertToEntityAttribute(Integer id) {
            return id != null ? NombreCurso.fromId(id) : null;
        }
    }
}
