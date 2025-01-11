package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.service.calificacion.EvolucionAcademicaDTO;
import com.niglesiasm.eduapp.service.calificacion.impl.CalificacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calificaciones")
public class CalificacionController {

    @Autowired
    private CalificacionServiceImpl calificacionService;


    @GetMapping("/{idAlumno}")
    @PreAuthorize("authentication.principal.claims['roles'].contains('ADMIN') || authentication.principal.claims['roles'].contains('PROF')")
    public List<EvolucionAcademicaDTO> getByAlumnoId(@PathVariable Integer idAlumno) {
        return calificacionService.getCalificacionesByAlumno(idAlumno);
    }

}