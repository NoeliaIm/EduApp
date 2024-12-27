package com.niglesiasm.eduapp.service.idioma;

import com.niglesiasm.eduapp.model.AlumnoIdioma;

import java.util.List;
import java.util.Set;

public interface AlumnoIdiomaMapper {

    AlumnoIdiomaDTO alumnoIdiomaToAlumnoIdiomaDTO(AlumnoIdioma alumnoIdioma);

    List<AlumnoIdiomaDTO> alumnosIdiomasToAlumnosIdiomasDTO(Set<AlumnoIdioma> alumnosIdiomas);

    AlumnoIdioma alumnoIdiomaDTOToAlumnoIdioma(AlumnoIdiomaDTO alumnoIdiomaDTO);

    Set<AlumnoIdioma> alumnosIdiomasDTOToAlumnosIdiomas(List<AlumnoIdiomaDTO> alumnosIdiomasDTO);
}
