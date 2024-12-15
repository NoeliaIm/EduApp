package com.niglesiasm.eduapp.service.curso;

import com.niglesiasm.eduapp.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {


    List<CursoDTO> getCursosAll();

    Optional<CursoDTO> findById(Integer id);

    Curso save(Curso entity);

    void deleteById(Integer id);
}
