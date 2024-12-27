package com.niglesiasm.eduapp.service.profesor;

import java.util.List;


public interface ProfesorService {


    List<ProfesorDTO> obtenerProfesoresByAnnioActual();

    void guardarOActualizarProfesor(ProfesorDTO profesorDTO);

    void deleteById(Integer id);

}
