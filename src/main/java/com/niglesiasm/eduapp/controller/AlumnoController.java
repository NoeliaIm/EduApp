package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.model.Alumno;
import com.niglesiasm.eduapp.service.alumno.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> getAll() {
        return alumnoService.getAlumnosAll();
    }

    @GetMapping("/{id}")
    public Optional<Alumno> getById(@PathVariable Integer id) {
        return alumnoService.findById(id);
    }

    @PostMapping
    public Alumno create(@RequestBody Alumno alumno) {
        return alumnoService.save(alumno);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alumnoService.deleteById(id);
    }
}