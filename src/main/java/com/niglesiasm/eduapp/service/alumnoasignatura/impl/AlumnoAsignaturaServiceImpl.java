package com.niglesiasm.eduapp.service.alumnoasignatura.impl;

import com.niglesiasm.eduapp.model.AlumnoAsignatura;
import com.niglesiasm.eduapp.repository.alumnoasignatura.AlumnoAsignaturaDao;
import com.niglesiasm.eduapp.service.alumnoasignatura.AlumnoAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoAsignaturaServiceImpl implements AlumnoAsignaturaService {

    private final AlumnoAsignaturaDao alumnoAsignaturaDao;

    @Autowired
    public AlumnoAsignaturaServiceImpl(AlumnoAsignaturaDao alumnoAsignaturaDao) {
        this.alumnoAsignaturaDao = alumnoAsignaturaDao;
    }

    @Override
    public void incrementarContadorPregunta(Integer idAlumno, Integer idAsignatura) {
        AlumnoAsignatura alumnoAsignatura = alumnoAsignaturaDao.findByAlumnoIdAndAsignaturaId(idAlumno, idAsignatura);

        alumnoAsignatura.incrementarContador();
        alumnoAsignaturaDao.save(alumnoAsignatura);
        alumnoAsignaturaDao.flush();
    }
}
