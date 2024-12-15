package com.niglesiasm.eduapp.service.persona;

import com.niglesiasm.eduapp.model.Persona;
import com.niglesiasm.eduapp.repository.persona.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaDao repository;

    @Autowired
    public PersonaService(PersonaDao repository) {
        this.repository = repository;
    }

    public List<Persona> findAll() {
        return repository.findAll();
    }

    public Optional<Persona> findById(Long id) {
        return repository.findById(id);
    }

    public Persona save(Persona entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
