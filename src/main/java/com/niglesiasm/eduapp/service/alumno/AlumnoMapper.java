package com.niglesiasm.eduapp.service.alumno;

import com.niglesiasm.eduapp.model.Alumno;

import java.util.List;

public interface AlumnoMapper {

    AlumnoDTO alumnoToAlumnoDTO(Alumno alumno);

    List<AlumnoDTO> alumnosToAlumnosDTO(List<Alumno> alumnos);
}
