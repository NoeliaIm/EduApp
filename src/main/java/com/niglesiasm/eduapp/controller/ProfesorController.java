package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.model.Profesor;
import com.niglesiasm.eduapp.service.profesor.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesors")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public List<Profesor> getAll() {
        return profesorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Profesor> getById(@PathVariable Long id) {
        return profesorService.findById(id);
    }

    @PostMapping
    public Profesor create(@RequestBody Profesor profesor) {
        return profesorService.save(profesor);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        profesorService.deleteById(id);
    }
}