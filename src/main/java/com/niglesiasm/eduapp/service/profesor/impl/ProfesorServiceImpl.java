package com.niglesiasm.eduapp.service.profesor.impl;

import com.niglesiasm.eduapp.model.Profesor;
import com.niglesiasm.eduapp.repository.profesor.ProfesorDao;
import com.niglesiasm.eduapp.service.profesor.ProfesorDTO;
import com.niglesiasm.eduapp.service.profesor.ProfesorMapper;
import com.niglesiasm.eduapp.service.profesor.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorDao profesorDao;

    private final ProfesorMapper profesorMapper;


    @Autowired
    public ProfesorServiceImpl(ProfesorDao profesorDao, ProfesorMapper profesorMapper) {
        this.profesorDao = profesorDao;
        this.profesorMapper = profesorMapper;
    }

    @Override
    public List<ProfesorDTO> obtenerProfesoresByAnnioActual() {
        List<Object[]> profesorList = profesorDao.obtenerProfesoresByAnnioActual();
        return this.profesorMapper.profesoresToProfesoresDTO(profesorList);
    }

    @Override
    public Optional<Profesor> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Profesor save(Profesor profesor) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
