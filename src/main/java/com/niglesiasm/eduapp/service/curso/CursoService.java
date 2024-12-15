package com.niglesiasm.eduapp.service.curso;

import com.niglesiasm.eduapp.model.Curso;
import com.niglesiasm.eduapp.repository.curso.CursoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoDao repository;

    @Autowired
    public CursoService(CursoDao repository) {
        this.repository = repository;
    }

    public List<Curso> findAll() {
        return repository.findAll();
    }

    public Optional<Curso> findById(Long id) {
        return repository.findById(id);
    }

    public Curso save(Curso entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
