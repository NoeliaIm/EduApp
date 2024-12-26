package com.niglesiasm.eduapp.service.persona;

import com.niglesiasm.eduapp.model.Persona;

import java.util.List;

public interface PersonaMapper {


    PersonaDTO personaToPersonaDTO(Persona persona);

    List<PersonaDTO> personasToPersonasDTO(List<Persona> personas);

    Persona personaDTOToPersona(PersonaDTO personaDTO);

    List<Persona> personasDTOToPersonas(List<PersonaDTO> personaDTOs);
}
