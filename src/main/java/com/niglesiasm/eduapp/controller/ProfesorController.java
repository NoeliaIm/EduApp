package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.model.Profesor;
import com.niglesiasm.eduapp.service.profesor.ProfesorDTO;
import com.niglesiasm.eduapp.service.profesor.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public List<ProfesorDTO> getAll() {
        return profesorService.obtenerProfesoresByAnnioActual();
    }

    @GetMapping("/{id}")
    public Optional<Profesor> getById(@PathVariable Integer id) {
        return profesorService.findById(id);
    }

    @PostMapping
    public Profesor create(@RequestBody Profesor profesor) {
        return profesorService.save(profesor);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        profesorService.deleteById(id);
    }
}