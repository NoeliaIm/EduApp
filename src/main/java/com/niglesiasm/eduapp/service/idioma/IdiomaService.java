package com.niglesiasm.eduapp.service.idioma;

import com.niglesiasm.eduapp.model.Idioma;
import com.niglesiasm.eduapp.repository.idioma.IdiomaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdiomaService {

    private final IdiomaDao repository;

    @Autowired
    public IdiomaService(IdiomaDao repository) {
        this.repository = repository;
    }

    public List<Idioma> findAll() {
        return repository.findAll();
    }

    public Optional<Idioma> findById(Integer id) {
        return repository.findById(id);
    }

    public Idioma save(Idioma entity) {
        return repository.save(entity);
    }
    
}
