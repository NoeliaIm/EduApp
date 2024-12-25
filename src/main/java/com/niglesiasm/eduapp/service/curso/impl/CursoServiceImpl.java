package com.niglesiasm.eduapp.service.curso.impl;

import com.niglesiasm.eduapp.model.Curso;
import com.niglesiasm.eduapp.repository.curso.CursoDao;
import com.niglesiasm.eduapp.service.curso.CursoDTO;
import com.niglesiasm.eduapp.service.curso.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoDao cursoDao;

    @Autowired
    public CursoServiceImpl(CursoDao cursoDao) {
        this.cursoDao = cursoDao;
    }

    @Override
    public List<CursoDTO> getCursosAll() {
        List<Curso> cursos = cursoDao.findAll();
        return getCursoDTOS(cursos);
    }

    private static List<CursoDTO> getCursoDTOS(List<Curso> cursos) {
        List<CursoDTO> cursoDTOS = new ArrayList<>(cursos.size());
        for (Curso curso : cursos) {
            CursoDTO cursoDTO = new CursoDTO();
            cursoDTO.setIdCurso(curso.getId());
            cursoDTO.setNombreCurso(curso.getIdNombre().getNombre());
            cursoDTO.setAnnio(curso.getIdAnio().getFecha_inicio(), curso.getIdAnio().getFecha_fin());
            cursoDTO.setActivo(curso.getIdAnio().getActivo());
            cursoDTOS.add(cursoDTO);
        }
        return cursoDTOS;
    }

    @Override
    public List<CursoDTO> getCursosActivos() {
        List<Curso> cursos = cursoDao.findAll().stream().filter(c -> c.getIdAnio().getActivo()).toList();
        return getCursoDTOS(cursos);
    }

    @Override
    public Optional<CursoDTO> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Curso save(Curso entity) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
