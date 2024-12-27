package com.niglesiasm.eduapp.service.alumnoambito.impl;

import com.niglesiasm.eduapp.model.AlumnoAmbito;
import com.niglesiasm.eduapp.model.AlumnoAmbitoId;
import com.niglesiasm.eduapp.model.AmbitoAcademico;
import com.niglesiasm.eduapp.model.NivelAcademico;
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


    @Override
    public AlumnoAmbito alumnoAmbitoDTOToAlumnoAmbito(AlumnoAmbitoDTO alumnoAmbitoDTO) {

        AlumnoAmbito alumnoAmbito = new AlumnoAmbito();

        // Crear y establecer el ID compuesto
        AlumnoAmbitoId id = new AlumnoAmbitoId();

        AmbitoAcademico ambito = new AmbitoAcademico();
        ambito.setId(alumnoAmbitoDTO.getAmbito().getIdAmbito());
        ambito.setNombre(alumnoAmbitoDTO.getAmbito().getNombreAmbito());
        id.setAmbito(ambito);

        alumnoAmbito.setId(id);

        // Establecer el nivel académico
        NivelAcademico nivelAcademico = new NivelAcademico();
        nivelAcademico.setId(alumnoAmbitoDTO.getNivelAcademico().getIdNivelAcademico());
        nivelAcademico.setDescripcion(alumnoAmbitoDTO.getNivelAcademico().getNombreNivelAcademico());
        alumnoAmbito.setNivelAcademico(nivelAcademico);

        return alumnoAmbito;
    }

    @Override
    public Set<AlumnoAmbito> alumnosAmbitoDTOToAlumnosAmbito(List<AlumnoAmbitoDTO> alumnosAmbitoDTO) {
        return alumnosAmbitoDTO.stream().map(this::alumnoAmbitoDTOToAlumnoAmbito).collect(java.util.stream.Collectors.toSet());
    }
}
