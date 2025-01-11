package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.service.alumno.AlumnoDTO;
import com.niglesiasm.eduapp.service.alumno.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    @PreAuthorize("authentication.principal.claims['roles'].contains('ADMIN') || authentication.principal.claims['roles'].contains('PROF')")
    public List<AlumnoDTO> getAll() {
        return alumnoService.getAlumnosAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("authentication.principal.claims['roles'].contains('ADMIN') || authentication.principal.claims['roles'].contains('PROF')")
    public Optional<AlumnoDTO> getById(@PathVariable Integer id) {
        return alumnoService.findById(id);
    }

    @PostMapping
    @PreAuthorize("authentication.principal.claims['roles'].contains('ADMIN')")
    public ResponseEntity<String> create(@RequestBody AlumnoDTO alumnoDTO) {
// TODO propagar excepción al front
        try {
            this.alumnoService.createOrUpdateAlumno(alumnoDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: " + e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("authentication.principal.claims['roles'].contains('ADMIN')")
    public void delete(@PathVariable Integer id) {
        alumnoService.deleteById(id);
    }
}