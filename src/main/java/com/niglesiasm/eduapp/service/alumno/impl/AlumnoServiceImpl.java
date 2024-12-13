package com.niglesiasm.eduapp.service.alumno.impl;

import com.niglesiasm.eduapp.model.Alumno;
import com.niglesiasm.eduapp.repository.alumno.AlumnoDao;
import com.niglesiasm.eduapp.service.alumno.AlumnoDTO;
import com.niglesiasm.eduapp.service.alumno.AlumnoService;
import jakarta.persistence.EntityNotFoundException;
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
    public List<Alumno> findAll() {
        return List.of();
    }

    @Override
    public Optional<Alumno> findById(Integer id) {
        Alumno alumno = alumnoDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Alumno no encontrado"));
        AlumnoDTO.fromEntity(alumno);

        return Optional.of(alumno);
    }

    @Override
    public Alumno save(Alumno entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
