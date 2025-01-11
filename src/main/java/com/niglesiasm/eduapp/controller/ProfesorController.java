package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.service.profesor.ProfesorDTO;
import com.niglesiasm.eduapp.service.profesor.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
@PreAuthorize("authentication.principal.claims['roles'].contains('ADMIN')")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public List<ProfesorDTO> getAll() {
        return profesorService.obtenerProfesoresByAnnioActual();
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ProfesorDTO profesorDTO) {
        profesorService.guardarOActualizarProfesor(profesorDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        profesorService.deleteById(id);
    }
}