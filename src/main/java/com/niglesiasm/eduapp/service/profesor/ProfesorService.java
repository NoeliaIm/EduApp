package com.niglesiasm.eduapp.service.profesor;

import com.niglesiasm.eduapp.model.Profesor;
import com.niglesiasm.eduapp.repository.profesor.ProfesorDao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    private final ProfesorDao repository;

    @Autowired
    public ProfesorService(ProfesorDao repository) {
        this.repository = repository;
    }

    public List<Profesor> findAll() {
        return repository.findAll();
    }

    public Optional<Profesor> findById(Long id) {
        return repository.findById(id);
    }

    public Profesor save(Profesor entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
