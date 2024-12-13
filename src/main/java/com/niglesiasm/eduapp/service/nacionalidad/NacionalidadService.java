package com.niglesiasm.eduapp.service.nacionalidad;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.niglesiasm.eduapp.repository.nacionalidad.NacionalidadDao;
import com.niglesiasm.eduapp.model.Nacionalidad;

import java.util.List;
import java.util.Optional;

@Service
public class NacionalidadService {

    private final NacionalidadDao repository;

    @Autowired
    public NacionalidadService(NacionalidadDao repository) {
        this.repository = repository;
    }

    public List<Nacionalidad> findAll() {
        return repository.findAll();
    }

    public Optional<Nacionalidad> findById(Long id) {
        return repository.findById(id);
    }

    public Nacionalidad save(Nacionalidad entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
