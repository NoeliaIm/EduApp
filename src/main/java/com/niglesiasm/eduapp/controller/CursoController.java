package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.model.Curso;
import com.niglesiasm.eduapp.service.curso.CursoDTO;
import com.niglesiasm.eduapp.service.curso.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<CursoDTO> getAll() {
        return cursoService.getCursosAll();
    }

    @GetMapping("/{id}")
    public Optional<CursoDTO> getById(@PathVariable Integer id) {
        return cursoService.findById(id);
    }

    @PostMapping
    public Curso create(@RequestBody Curso curso) {
        return cursoService.save(curso);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cursoService.deleteById(id);
    }
}