package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.model.Nacionalidad;
import com.niglesiasm.eduapp.service.nacionalidad.NacionalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nacionalidads")
public class NacionalidadController {


    private NacionalidadService nacionalidadService;

    @Autowired
    public NacionalidadController(NacionalidadService nacionalidadService) {
        this.nacionalidadService = nacionalidadService;
    }

    @GetMapping
    public List<Nacionalidad> getAll() {
        return nacionalidadService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Nacionalidad> getById(@PathVariable Integer id) {
        return nacionalidadService.findById(id);
    }

    @PostMapping
    public Nacionalidad create(@RequestBody Nacionalidad nacionalidad) {
        return nacionalidadService.save(nacionalidad);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        nacionalidadService.deleteById(id);
    }
}