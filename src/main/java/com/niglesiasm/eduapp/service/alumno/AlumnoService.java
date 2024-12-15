package com.niglesiasm.eduapp.service.alumno;

import com.niglesiasm.eduapp.model.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {


    List<Alumno> getAlumnosAll();

    Optional<Alumno> findById(Integer id);

    Alumno save(Alumno entity);

    void deleteById(Long id);
}
