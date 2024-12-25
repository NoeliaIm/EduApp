package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.model.Idioma;
import com.niglesiasm.eduapp.service.idioma.IdiomaService;
import com.niglesiasm.eduapp.service.niveles.NivelIdiomaDTO;
import com.niglesiasm.eduapp.service.niveles.NivelIdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/idiomas")
public class IdiomaController {

    private IdiomaService idiomaService;

    private NivelIdiomaService nivelIdiomaService;

    @Autowired
    public IdiomaController(IdiomaService idiomaService, NivelIdiomaService nivelIdiomaService) {
        this.idiomaService = idiomaService;
        this.nivelIdiomaService = nivelIdiomaService;
    }

    @GetMapping
    public List<Idioma> getAll() {
        return idiomaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Idioma> getById(@PathVariable Integer id) {
        return idiomaService.findById(id);
    }

    @GetMapping("/niveles")
    public List<NivelIdiomaDTO> getAllNiveles() {
        return nivelIdiomaService.getAllNivelesIdioma();
    }

}