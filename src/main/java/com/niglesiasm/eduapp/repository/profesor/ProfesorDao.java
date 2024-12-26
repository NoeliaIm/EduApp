package com.niglesiasm.eduapp.repository.profesor;

import com.niglesiasm.eduapp.model.Profesor;

import java.util.List;

public interface ProfesorDao {

    List<Object[]> obtenerProfesoresByAnnioActual();

    Profesor findProfesorByEmail(String email);

    void guardarProfesor(Profesor profesor);


}
