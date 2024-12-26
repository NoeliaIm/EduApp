package com.niglesiasm.eduapp.service.profesor;

import com.niglesiasm.eduapp.model.Profesor;

import java.util.List;
import java.util.Optional;


public interface ProfesorService {


    List<ProfesorDTO> obtenerProfesoresByAnnioActual();

    Optional<Profesor> findById(Integer id);

    void guardarOActualizarProfesor(ProfesorDTO profesorDTO);

    void deleteById(Integer id);

}
