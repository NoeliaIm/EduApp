package com.niglesiasm.eduapp.service.persona.impl;

import com.niglesiasm.eduapp.model.Persona;
import com.niglesiasm.eduapp.service.persona.PersonaDTO;
import com.niglesiasm.eduapp.service.persona.PersonaMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaMapperImpl implements PersonaMapper {

    @Override
    public PersonaDTO personaToPersonaDTO(Persona persona) {
        if (persona == null) {
            return null;
        }
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setId(persona.getId());
        personaDTO.setNombre(persona.getNombre());
        personaDTO.setApellido1(persona.getApellido1());
        personaDTO.setApellido2(persona.getApellido2());
        personaDTO.setEmail(persona.getEmail());
        return personaDTO;
    }

    @Override
    public List<PersonaDTO> personasToPersonasDTO(List<Persona> personas) {
        if (personas == null) {
            return null;
        }
        List<PersonaDTO> list = new ArrayList<PersonaDTO>(personas.size());
        for (Persona persona : personas) {
            list.add(personaToPersonaDTO(persona));
        }
        return list;
    }


    @Override
    public Persona personaDTOToPersona(PersonaDTO personaDTO) {
        if (personaDTO == null) {
            return null;
        }
        Persona persona = new Persona();
        persona.setId(personaDTO.getId());
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido1(personaDTO.getApellido1());
        persona.setApellido2(personaDTO.getApellido2());
        persona.setEmail(personaDTO.getEmail());
        return persona;
    }

    @Override
    public List<Persona> personasDTOToPersonas(List<PersonaDTO> personaDTOs) {
        if (personaDTOs == null) {
            return null;
        }
        List<Persona> list = new ArrayList<Persona>(personaDTOs.size());
        for (PersonaDTO personaDTO : personaDTOs) {
            list.add(personaDTOToPersona(personaDTO));
        }
        return list;
    }
}
