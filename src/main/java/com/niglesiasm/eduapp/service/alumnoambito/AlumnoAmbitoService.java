package com.niglesiasm.eduapp.service.alumnoambito;

import com.niglesiasm.eduapp.model.AlumnoAmbito;
import com.niglesiasm.eduapp.repository.alumnoambito.AlumnoAmbitoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoAmbitoService {

    private final AlumnoAmbitoDao repository;

    @Autowired
    public AlumnoAmbitoService(AlumnoAmbitoDao repository) {
        this.repository = repository;
    }

    public List<AlumnoAmbito> findAll() {
        return repository.findAll();
    }

    public Optional<AlumnoAmbito> findById(Long id) {
        return repository.findById(id);
    }

    public AlumnoAmbito save(AlumnoAmbito entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
