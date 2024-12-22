package com.niglesiasm.eduapp.service.alumno.impl;

import com.niglesiasm.eduapp.model.Alumno;
import com.niglesiasm.eduapp.repository.alumno.AlumnoDao;
import com.niglesiasm.eduapp.service.alumno.AlumnoDTO;
import com.niglesiasm.eduapp.service.alumno.AlumnoMapper;
import com.niglesiasm.eduapp.service.alumno.AlumnoService;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {


    private final AlumnoDao alumnoDao;
    private final AlumnoMapper alumnoMapper;
    private final AsignaturaService asignaturaService;

    @Autowired
    AlumnoServiceImpl(AlumnoDao alumnoDao, AlumnoMapper alumnoMapper, AsignaturaService asignaturaService) {
        this.alumnoDao = alumnoDao;
        this.alumnoMapper = alumnoMapper;
        this.asignaturaService = asignaturaService;
    }

    @Override
    public List<AlumnoDTO> getAlumnosAll() {
        List<Alumno> alumnoList = alumnoDao.findAll();

        return alumnoMapper.alumnosToAlumnosDTO(alumnoList);
    }

    @Override
    public Optional<AlumnoDTO> findById(Integer id) {
        Optional<Alumno> alumno = alumnoDao.findById(id);

        if (alumno.isPresent()) {
            AlumnoDTO alumnoDTO = alumnoMapper.alumnoToAlumnoDTO(alumno.get());
            return Optional.of(alumnoDTO);
        }
        return Optional.empty();
    }

    @Override
    public Alumno save(Alumno entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
