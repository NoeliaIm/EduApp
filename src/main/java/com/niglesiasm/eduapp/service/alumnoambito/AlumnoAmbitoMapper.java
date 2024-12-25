package com.niglesiasm.eduapp.service.alumnoambito;

import com.niglesiasm.eduapp.model.AlumnoAmbito;

import java.util.List;
import java.util.Set;

public interface AlumnoAmbitoMapper {

    AlumnoAmbitoDTO alumnoAmbitoToAlumnoAmbitoDTO(AlumnoAmbito alumnoAmbito);

    List<AlumnoAmbitoDTO> alumnosAmbitoToAlumnosAmbitoDTO(Set<AlumnoAmbito> alumnosAmbito);
}
