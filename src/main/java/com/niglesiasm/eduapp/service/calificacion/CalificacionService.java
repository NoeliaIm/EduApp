package com.niglesiasm.eduapp.service.calificacion;

import com.niglesiasm.eduapp.model.Calificacion;
import com.niglesiasm.eduapp.repository.calificacion.CalificacionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionService {

    private final CalificacionDao repository;

    @Autowired
    public CalificacionService(CalificacionDao repository) {
        this.repository = repository;
    }

    public List<Calificacion> findAll() {
        return repository.findAll();
    }

    public Optional<Calificacion> findById(Long id) {
        return repository.findById(id);
    }

    public Calificacion save(Calificacion entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
