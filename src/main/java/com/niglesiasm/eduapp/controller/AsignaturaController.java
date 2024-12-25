package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.model.Asignatura;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping
    public List<AsignaturaDTO> getAll() {
        return asignaturaService.getAsignaturasAll();
    }

    @GetMapping("/{id}")
    public Optional<AsignaturaDTO> getById(@PathVariable Integer id) {
        return asignaturaService.findById(id);
    }

    @PostMapping
    public Asignatura create(@RequestBody Asignatura asignatura) {
        return asignaturaService.save(asignatura);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        asignaturaService.deleteById(id);
    }
}