package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.model.Persona;
import com.niglesiasm.eduapp.service.persona.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAll() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Persona> getById(@PathVariable Long id) {
        return personaService.findById(id);
    }

    @PostMapping
    public Persona create(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PutMapping("/{id}")
    public Persona update(@PathVariable Integer id, @RequestBody Persona persona) {
        persona.setId(id);
        return personaService.save(persona);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personaService.deleteById(id);
    }
}