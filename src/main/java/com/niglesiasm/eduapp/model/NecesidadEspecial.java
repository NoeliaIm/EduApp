package com.niglesiasm.eduapp.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.Getter;

@Getter
public enum NecesidadEspecial {


    TEA(1, "TEA"), TDAH(2, "TDAH"), AC(3, "AC"), PAS(4, "PAS");
    private int id;
    private String nombre;

    NecesidadEspecial(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public static NecesidadEspecial fromId(int id) {
        for (NecesidadEspecial necesidadEspecial : values()) {
            if (necesidadEspecial.id == id) {
                return necesidadEspecial;
            }
        }
        throw new IllegalArgumentException("Invalid Rol id: " + id);
    }

    public static NecesidadEspecial fromName(String nombre) {
        for (NecesidadEspecial necesidadEspecial : values()) {
            if (necesidadEspecial.nombre.equalsIgnoreCase(nombre)) {
                return necesidadEspecial;
            }
        }
        throw new IllegalArgumentException("Invalid NecesidadEspecial name: " + nombre);
    }

    // Converter para JPA
    @Converter(autoApply = true)
    public static class NEConverter implements AttributeConverter<NecesidadEspecial, Integer> {
        @Override
        public Integer convertToDatabaseColumn(NecesidadEspecial necesidadEspecial) {
            return necesidadEspecial != null ? necesidadEspecial.getId() : null;
        }

        @Override
        public NecesidadEspecial convertToEntityAttribute(Integer id) {
            return id != null ? NecesidadEspecial.fromId(id) : null;
        }
    }
}
