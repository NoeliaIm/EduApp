package com.niglesiasm.eduapp.model;

import java.util.Arrays;
import java.util.List;

public enum NivelIdioma {

    A1(1, "A1"),A2(2, "A2"),B1(3, "B1"),B2(4, "B2"),C1(5, "C1"),C2(6, "C2");

    private int id;
    private String nombre;

    NivelIdioma(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public NivelIdioma getNivelIdiomaById(int id){
        for(NivelIdioma n : NivelIdioma.values()){
            if(n.id == id){
                return n;
            }
        }
        return null;
    }

    public NivelIdioma getNivelIdiomaByNombre(String nombre){
        for(NivelIdioma n : NivelIdioma.values()){
            if(n.nombre.equals(nombre)){
                return n;
            }
        }
        return null;
    }

    public List<NivelIdioma> getAllNivelesIdiomas(){
        return Arrays.asList(NivelIdioma.values());
    }
}
