package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.service.alumno.AlumnoDTO;
import com.niglesiasm.eduapp.service.alumno.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<AlumnoDTO> getAll() {
        return alumnoService.getAlumnosAll();
    }

    @GetMapping("/{id}")
    public Optional<AlumnoDTO> getById(@PathVariable Integer id) {
        return alumnoService.findById(id);
    }

    @PostMapping
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
    public void delete(@PathVariable Long id) {
        alumnoService.deleteById(id);
    }
}