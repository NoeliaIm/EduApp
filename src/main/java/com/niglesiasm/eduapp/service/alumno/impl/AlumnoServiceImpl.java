package com.niglesiasm.eduapp.service.alumno.impl;

import com.niglesiasm.eduapp.model.Alumno;
import com.niglesiasm.eduapp.repository.alumno.AlumnoDao;
import com.niglesiasm.eduapp.service.alumno.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {


    private AlumnoDao alumnoDao;

    @Autowired
    AlumnoServiceImpl(AlumnoDao alumnoDao) {
        this.alumnoDao = alumnoDao;
    }

    @Override
    public List<Alumno> getAlumnosAll() {
        return alumnoDao.findAll();
    }

    @Override
    public Optional<Alumno> findById(Integer id) {
        return alumnoDao.findById(id);

    }

    @Override
    public Alumno save(Alumno entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
