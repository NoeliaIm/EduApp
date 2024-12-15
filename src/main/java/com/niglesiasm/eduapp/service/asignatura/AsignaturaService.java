package com.niglesiasm.eduapp.service.asignatura;

import com.niglesiasm.eduapp.model.Asignatura;
import com.niglesiasm.eduapp.repository.asignatura.AsignaturaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService {

    private final AsignaturaDao repository;

    @Autowired
    public AsignaturaService(AsignaturaDao repository) {
        this.repository = repository;
    }

    public List<Asignatura> findAll() {
        return repository.findAll();
    }

    public Optional<Asignatura> findById(Long id) {
        return repository.findById(id);
    }

    public Asignatura save(Asignatura entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
