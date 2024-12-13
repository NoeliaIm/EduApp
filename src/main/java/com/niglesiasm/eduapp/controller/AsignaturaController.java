package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.model.Asignatura;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping
    public List<Asignatura> getAll() {
        return asignaturaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Asignatura> getById(@PathVariable Long id) {
        return asignaturaService.findById(id);
    }

    @PostMapping
    public Asignatura create(@RequestBody Asignatura asignatura) {
        return asignaturaService.save(asignatura);
    }

    @PutMapping("/{id}")
    public Asignatura update(@PathVariable Integer id, @RequestBody Asignatura asignatura) {
        asignatura.setId(id);
        return asignaturaService.save(asignatura);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        asignaturaService.deleteById(id);
    }
}