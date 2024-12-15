package com.niglesiasm.eduapp.service.curso.impl;

import com.niglesiasm.eduapp.model.Curso;
import com.niglesiasm.eduapp.repository.curso.CursoDao;
import com.niglesiasm.eduapp.service.curso.CursoDTO;
import com.niglesiasm.eduapp.service.curso.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return List.of();
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
