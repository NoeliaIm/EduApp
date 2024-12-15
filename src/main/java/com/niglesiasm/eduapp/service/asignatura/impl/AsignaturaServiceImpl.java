package com.niglesiasm.eduapp.service.asignatura.impl;

import com.niglesiasm.eduapp.model.Asignatura;
import com.niglesiasm.eduapp.repository.asignatura.AsignaturaDao;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    private final AsignaturaDao asignaturaDao;

    @Autowired
    public AsignaturaServiceImpl(AsignaturaDao asignaturaDao) {
        this.asignaturaDao = asignaturaDao;
    }

    @Override
    public List<AsignaturaDTO> getAsignaturasAll() {
        List<AsignaturaDTO> asignaturas = asignaturaDao.obtenerAsignaturasByAnnioActual();
        return asignaturas;
    }

    @Override
    public Optional<AsignaturaDTO> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Asignatura save(Asignatura entity) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
