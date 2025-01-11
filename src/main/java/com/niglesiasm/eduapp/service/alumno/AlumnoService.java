package com.niglesiasm.eduapp.service.alumno;


import java.util.List;
import java.util.Optional;

public interface AlumnoService {


    List<AlumnoDTO> getAlumnosAll();

    Optional<AlumnoDTO> findById(Integer id);

    void deleteById(Integer id);

    void createOrUpdateAlumno(AlumnoDTO alumnoDTO);
}
