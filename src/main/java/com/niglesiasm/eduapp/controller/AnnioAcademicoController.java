package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.model.AnnioAcademico;
import com.niglesiasm.eduapp.service.annioacademico.AnnioAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/annioAcademicos")
public class AnnioAcademicoController {

    @Autowired
    private AnnioAcademicoService annioAcademicoService;

    @GetMapping
    public List<AnnioAcademico> getAll() {
        return annioAcademicoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<AnnioAcademico> getById(@PathVariable Long id) {
        return annioAcademicoService.findById(id);
    }

    @PostMapping
    public AnnioAcademico create(@RequestBody AnnioAcademico annioAcademico) {
        return annioAcademicoService.save(annioAcademico);
    }

    @PutMapping("/{id}")
    public AnnioAcademico update(@PathVariable Integer id, @RequestBody AnnioAcademico annioAcademico) {
        annioAcademico.setId(id);
        return annioAcademicoService.save(annioAcademico);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        annioAcademicoService.deleteById(id);
    }
}