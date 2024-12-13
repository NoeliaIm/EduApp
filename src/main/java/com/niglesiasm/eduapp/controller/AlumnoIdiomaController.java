package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.model.AlumnoIdioma;
import com.niglesiasm.eduapp.service.alumnoidioma.AlumnoIdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/alumnoIdiomas")
public class AlumnoIdiomaController {

    @Autowired
    private AlumnoIdiomaService alumnoIdiomaService;

    @GetMapping
    public List<AlumnoIdioma> getAll() {
        return alumnoIdiomaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<AlumnoIdioma> getById(@PathVariable Long id) {
        return alumnoIdiomaService.findById(id);
    }

    @PostMapping
    public AlumnoIdioma create(@RequestBody AlumnoIdioma alumnoIdioma) {
        return alumnoIdiomaService.save(alumnoIdioma);
    }

    @PutMapping("/{id}")
    public AlumnoIdioma update(@PathVariable Integer id, @RequestBody AlumnoIdioma alumnoIdioma) {
        alumnoIdioma.setId(id);
        return alumnoIdiomaService.save(alumnoIdioma);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alumnoIdiomaService.deleteById(id);
    }
}