package com.niglesiasm.eduapp.repository.alumno;

import com.niglesiasm.eduapp.model.Alumno;

import java.util.List;
import java.util.Optional;


public interface AlumnoDao {

    List<Alumno> getAlumnosAnnioEncurso();

    Optional<Alumno> findById(Integer id);

    Alumno save(Alumno alumnoPersist);
}
