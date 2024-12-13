package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.model.AlumnoAmbito;
import com.niglesiasm.eduapp.service.alumnoambito.AlumnoAmbitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnoAmbitos")
public class AlumnoAmbitoController {

    @Autowired
    private AlumnoAmbitoService alumnoAmbitoService;

    @GetMapping
    public List<AlumnoAmbito> getAll() {
        return alumnoAmbitoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<AlumnoAmbito> getById(@PathVariable Long id) {
        return alumnoAmbitoService.findById(id);
    }

    @PostMapping
    public AlumnoAmbito create(@RequestBody AlumnoAmbito alumnoAmbito) {
        return alumnoAmbitoService.save(alumnoAmbito);
    }

    @PutMapping("/{id}")
    public AlumnoAmbito update(@PathVariable Integer id, @RequestBody AlumnoAmbito alumnoAmbito) {
        alumnoAmbito.setIdAlumno(id);
        return alumnoAmbitoService.save(alumnoAmbito);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alumnoAmbitoService.deleteById(id);
    }
}