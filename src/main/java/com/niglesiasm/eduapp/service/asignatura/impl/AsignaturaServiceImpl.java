package com.niglesiasm.eduapp.service.asignatura.impl;

import com.niglesiasm.eduapp.model.Asignatura;
import com.niglesiasm.eduapp.model.Curso;
import com.niglesiasm.eduapp.repository.asignatura.AsignaturaDao;
import com.niglesiasm.eduapp.repository.curso.CursoDao;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    private final AsignaturaDao asignaturaDao;

    private final CursoDao cursoDao;

    @Autowired
    public AsignaturaServiceImpl(AsignaturaDao asignaturaDao, CursoDao cursoDao) {
        this.asignaturaDao = asignaturaDao;
        this.cursoDao = cursoDao;
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
    @Transactional
    public void createOrUpdateAsignatura(AsignaturaDTO asignaturaDTO) {
        if (asignaturaDTO.getIdAsignatura() != null) {
            Asignatura asignatura = this.asignaturaDao.findByIdAsignatura(asignaturaDTO.getIdAsignatura());
            guardarAsignatura(asignaturaDTO, asignatura);
            return;
        }
        Asignatura asignatura = new Asignatura();
        guardarAsignatura(asignaturaDTO, asignatura);
    }

    private void guardarAsignatura(AsignaturaDTO asignaturaDTO, Asignatura asignatura) {
        asignatura.setNombreAsignatura(asignaturaDTO.getNombreAsignatura());
        asignatura.setDescripcion(asignaturaDTO.getDescripcion());
        asignatura.setAcron(asignaturaDTO.getAcron());
        Curso curso = this.cursoDao.findById(asignaturaDTO.getIdCurso()).orElseThrow();
        asignatura.setIdCurso(curso);
        this.asignaturaDao.guardarAsignatura(asignatura);
    }

    @Override
    public void deleteById(Integer id) {

    }
}
