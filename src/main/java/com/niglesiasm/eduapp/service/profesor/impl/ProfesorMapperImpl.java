package com.niglesiasm.eduapp.service.profesor.impl;

import com.niglesiasm.eduapp.model.Profesor;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaMapper;
import com.niglesiasm.eduapp.service.persona.PersonaDTO;
import com.niglesiasm.eduapp.service.persona.PersonaMapper;
import com.niglesiasm.eduapp.service.profesor.ProfesorDTO;
import com.niglesiasm.eduapp.service.profesor.ProfesorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProfesorMapperImpl implements ProfesorMapper {

    PersonaMapper personaMapper;

    AsignaturaMapper asignaturaMapper;

    @Autowired
    public ProfesorMapperImpl(PersonaMapper personaMapper, AsignaturaMapper asignaturaMapper) {
        this.personaMapper = personaMapper;
        this.asignaturaMapper = asignaturaMapper;
    }

    @Override
    public ProfesorDTO profesorToProfesorDTO(Profesor profesor) {
        if (profesor == null) {
            return null;
        }
        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setIdProfesor(profesor.getId());
        PersonaDTO personaDTO = this.personaMapper.personaToPersonaDTO(profesor.getPersona());

        return profesorDTO;
    }

    @Override
    public List<ProfesorDTO> profesoresToProfesoresDTO(List<Object[]> profesores) {

        Map<Integer, ProfesorDTO> profesorMap = new HashMap<>();

        // Procesar los resultados y mapear directamente a ProfesorDTO
        profesores.forEach(resultado -> {
            Integer idProfesor = (Integer) resultado[0];
            Integer idPersona = (Integer) resultado[1];
            String nombrePersona = (String) resultado[2];
            String apellido1Persona = (String) resultado[3];
            String apellido2Persona = (String) resultado[4];
            Integer idAsignatura = (Integer) resultado[5];
            String nombreAsignatura = (String) resultado[6];
            Integer idCurso = (Integer) resultado[7];
            String nombreCurso = (String) resultado[8];
            String descripcionAsignatura = (String) resultado[9];
            String acronAsignatura = (String) resultado[10];

            // Crear o recuperar el ProfesorDTO
            ProfesorDTO profesorDTO = profesorMap.computeIfAbsent(idProfesor, k -> {
                ProfesorDTO nuevoProfesorDTO = new ProfesorDTO();
                nuevoProfesorDTO.setIdProfesor(idProfesor);
                PersonaDTO personaDTO = new PersonaDTO();
                personaDTO.setId(idPersona);
                personaDTO.setNombre(nombrePersona);
                personaDTO.setApellido1(apellido1Persona);
                personaDTO.setApellido2(apellido2Persona);
                nuevoProfesorDTO.setPersona(personaDTO);
                nuevoProfesorDTO.setAsignaturas(new ArrayList<>());
                return nuevoProfesorDTO;
            });

            // Agregar la Asignatura correspondiente al Profesor
            profesorDTO.getAsignaturas().add(new AsignaturaDTO(
                    idAsignatura,
                    nombreAsignatura,
                    idCurso,
                    nombreCurso,
                    descripcionAsignatura,
                    acronAsignatura
            ));
        });

        // Retornar la lista directamente
        return new ArrayList<>(profesorMap.values());
    }

    @Override
    public Profesor profesorDTOToProfesor(ProfesorDTO profesorDTO) {
        if (profesorDTO == null) {
            return null;
        }
        Profesor profesor = new Profesor();
        profesor.setId(profesorDTO.getIdProfesor());
        profesor.setPersona(this.personaMapper.personaDTOToPersona(profesorDTO.getPersona()));
        profesor.setAsignaturas(this.asignaturaMapper.asignaturasDTOToAsignaturas(profesorDTO.getAsignaturas()));
        return profesor;
    }
}
