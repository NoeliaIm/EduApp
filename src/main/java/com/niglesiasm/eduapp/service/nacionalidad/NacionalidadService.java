package com.niglesiasm.eduapp.service.nacionalidad;

import com.niglesiasm.eduapp.model.Nacionalidad;
import com.niglesiasm.eduapp.repository.nacionalidad.NacionalidadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Optional<Nacionalidad> findById(Integer id) {
        return repository.findById(id);
    }

    public Nacionalidad save(Nacionalidad entity) {
        return repository.save(entity);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
