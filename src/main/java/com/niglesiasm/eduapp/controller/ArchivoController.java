package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.service.archivo.ArchivoDTO;
import com.niglesiasm.eduapp.service.archivo.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/archivos")
public class ArchivoController {


    private final ArchivoService archivoService;

    @Autowired
    public ArchivoController(ArchivoService archivoService) {
        this.archivoService = archivoService;
    }

    @GetMapping
    List<ArchivoDTO> getAll() {
        return archivoService.getArchivosAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        archivoService.deleteById(id);
    }
}
