package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {


    private AsignaturaService asignaturaService;

    @Autowired
    public AsignaturaController(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    @GetMapping
    @PreAuthorize("authentication.principal.claims['roles'].contains('ADMIN') || authentication.principal.claims['roles'].contains('PROF')")
    public List<AsignaturaDTO> getAll() {
        return asignaturaService.getAsignaturasAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("authentication.principal.claims['roles'].contains('ADMIN') || authentication.principal.claims['roles'].contains('PROF')")
    public Optional<AsignaturaDTO> getById(@PathVariable Integer id) {
        return asignaturaService.findById(id);
    }

    @PostMapping
    @PreAuthorize("authentication.principal.claims['roles'].contains('ADMIN')")
    public ResponseEntity<Void> createOrUpdate(@RequestBody AsignaturaDTO asignatura) {
        this.asignaturaService.createOrUpdateAsignatura(asignatura);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("authentication.principal.claims['roles'].contains('ADMIN')")
    public void delete(@PathVariable Integer id) {
        asignaturaService.deleteById(id);
    }
}