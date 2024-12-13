package com.niglesiasm.eduapp.model;

import java.util.Arrays;
import java.util.List;

public enum NivelAcademico {

    BAJO(1, "Bajo"),MEDIO_BAJO(2, "Medio-Bajo"),MEDIO(3, "Medio"),MEDIO_ALTO(4, "Medio-Alto"),ALTO(5, "Alto");

    private int id;
    private String nombre;

    NivelAcademico(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public NivelAcademico getNivelAcademicoById(int id){
        for(NivelAcademico n : NivelAcademico.values()){
            if(n.id == id){
                return n;
            }
        }
        return null;
    }

    public NivelAcademico getNivelAcademicoByNombre(String nombre){
        for(NivelAcademico n : NivelAcademico.values()){
            if(n.nombre.equals(nombre)){
                return n;
            }
        }
        return null;
    }

    public List<NivelAcademico> getAllNivelesAcademicos(){
        return Arrays.asList(NivelAcademico.values());
    }
}
