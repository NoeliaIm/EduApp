package com.niglesiasm.eduapp.service.profesor;

import com.niglesiasm.eduapp.model.Profesor;

import java.util.List;

public interface ProfesorMapper {

    ProfesorDTO profesorToProfesorDTO(Profesor profesor);

    List<ProfesorDTO> profesoresToProfesoresDTO(List<Object[]> profesores);

    Profesor profesorDTOToProfesor(ProfesorDTO profesorDTO);
}
