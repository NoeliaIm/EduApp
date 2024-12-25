package com.niglesiasm.eduapp.service.persona;

import com.niglesiasm.eduapp.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PersonaService {


    List<PersonaDTO> getPersonsAll();

    Optional<PersonaDTO> findById(Integer id);

    Persona save(Persona entity);

    void deleteById(Integer id);
}
