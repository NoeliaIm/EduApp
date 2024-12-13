package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.model.Calificacion;
import com.niglesiasm.eduapp.service.calificacion.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/calificacions")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @GetMapping
    public List<Calificacion> getAll() {
        return calificacionService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Calificacion> getById(@PathVariable Long id) {
        return calificacionService.findById(id);
    }

    @PostMapping
    public Calificacion create(@RequestBody Calificacion calificacion) {
        return calificacionService.save(calificacion);
    }

    @PutMapping("/{id}")
    public Calificacion update(@PathVariable Integer id, @RequestBody Calificacion calificacion) {
        calificacion.setId(id);
        return calificacionService.save(calificacion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        calificacionService.deleteById(id);
    }
}