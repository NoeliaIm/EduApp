package com.niglesiasm.eduapp.service.alumno;

import com.niglesiasm.eduapp.model.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {


    List<AlumnoDTO> getAlumnosAll();

    Optional<AlumnoDTO> findById(Integer id);

    Alumno save(Alumno entity);

    void deleteById(Long id);

    void createOrUpdateAlumno(AlumnoDTO alumnoDTO);
}
