package com.niglesiasm.eduapp.service.persona.impl;

import com.niglesiasm.eduapp.model.Persona;
import com.niglesiasm.eduapp.repository.persona.PersonaDao;
import com.niglesiasm.eduapp.service.persona.PersonaDTO;
import com.niglesiasm.eduapp.service.persona.PersonaMapper;
import com.niglesiasm.eduapp.service.persona.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    private final PersonaDao personaDao;
    private final PersonaMapper personaMapper;

    @Autowired
    public PersonaServiceImpl(PersonaDao personaDao, PersonaMapper personaMapper) {
        this.personaDao = personaDao;
        this.personaMapper = personaMapper;
    }

    @Override
    public List<PersonaDTO> getPersonsAll() {
        List<Persona> personas = personaDao.findAll();
        return this.personaMapper.personasToPersonasDTO(personas);
    }

    @Override
    public Optional<PersonaDTO> findById(Integer id) {
        Optional<Persona> persona = personaDao.findById(id);
        if (persona.isPresent()) {
            PersonaDTO personaDTO = personaMapper.personaToPersonaDTO(persona.get());
            return Optional.of(personaDTO);
        }
        return Optional.empty();
    }

    @Override
    public Persona save(Persona entity) {
        return personaDao.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        personaDao.deleteById(id);
    }
}
