package com.niglesiasm.eduapp.service.alumnoambito.impl;

import com.niglesiasm.eduapp.model.AlumnoAmbito;
import com.niglesiasm.eduapp.service.alumnoambito.AlumnoAmbitoDTO;
import com.niglesiasm.eduapp.service.alumnoambito.AlumnoAmbitoMapper;
import com.niglesiasm.eduapp.service.alumnoambito.AmbitoDTO;
import com.niglesiasm.eduapp.service.niveles.NivelAcademicoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AlumnoAmbitoMapperImpl implements AlumnoAmbitoMapper {

    @Override
    public AlumnoAmbitoDTO alumnoAmbitoToAlumnoAmbitoDTO(AlumnoAmbito alumnoAmbito) {
        AlumnoAmbitoDTO alumnoAmbitoDTO = new AlumnoAmbitoDTO();
        AmbitoDTO ambitoDTO = new AmbitoDTO();
        ambitoDTO.setIdAmbito(alumnoAmbito.getId().getAmbito().getId());
        ambitoDTO.setNombreAmbito(alumnoAmbito.getId().getAmbito().getNombre());
        alumnoAmbitoDTO.setAmbito(ambitoDTO);
        NivelAcademicoDTO nivelAcademicoDTO = new NivelAcademicoDTO();
        nivelAcademicoDTO.setIdNivelAcademico(alumnoAmbito.getNivelAcademico().getId());
        nivelAcademicoDTO.setNombreNivelAcademico(alumnoAmbito.getNivelAcademico().getDescripcion());
        alumnoAmbitoDTO.setNivelAcademico(nivelAcademicoDTO);
        return alumnoAmbitoDTO;
    }

    @Override
    public List<AlumnoAmbitoDTO> alumnosAmbitoToAlumnosAmbitoDTO(Set<AlumnoAmbito> alumnosAmbito) {
        List<AlumnoAmbitoDTO> alumnoAmbitoDTOS = new ArrayList<>(alumnosAmbito.size());
        for (AlumnoAmbito alumnoAmbito : alumnosAmbito) {
            alumnoAmbitoDTOS.add(alumnoAmbitoToAlumnoAmbitoDTO(alumnoAmbito));
        }
        return alumnoAmbitoDTOS;
    }
}
