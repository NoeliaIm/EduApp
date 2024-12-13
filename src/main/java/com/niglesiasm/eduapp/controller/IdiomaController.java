package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.model.Idioma;
import com.niglesiasm.eduapp.service.idioma.IdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/idiomas")
public class IdiomaController {

    @Autowired
    private IdiomaService idiomaService;

    @GetMapping
    public List<Idioma> getAll() {
        return idiomaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Idioma> getById(@PathVariable Long id) {
        return idiomaService.findById(id);
    }

    @PostMapping
    public Idioma create(@RequestBody Idioma idioma) {
        return idiomaService.save(idioma);
    }

    @PutMapping("/{id}")
    public Idioma update(@PathVariable Integer id, @RequestBody Idioma idioma) {
        idioma.setId(id);
        return idiomaService.save(idioma);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        idiomaService.deleteById(id);
    }
}