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
}
