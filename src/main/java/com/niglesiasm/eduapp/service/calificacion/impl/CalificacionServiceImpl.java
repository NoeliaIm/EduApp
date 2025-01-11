package com.niglesiasm.eduapp.service.calificacion.impl;

import com.niglesiasm.eduapp.model.Calificacion;
import com.niglesiasm.eduapp.repository.calificacion.CalificacionDao;
import com.niglesiasm.eduapp.service.calificacion.CalificacionService;
import com.niglesiasm.eduapp.service.calificacion.EvolucionAcademicaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CalificacionServiceImpl implements CalificacionService {

    private final CalificacionDao repository;

    @Autowired
    public CalificacionServiceImpl(CalificacionDao repository) {
        this.repository = repository;
    }

    public List<EvolucionAcademicaDTO> getCalificacionesByAlumno(Integer idAlumno) {
        List<Calificacion> calificaciones = repository.findByAlumnoId(idAlumno);
        Map<String, EvolucionAcademicaDTO> evolucionPorAsignatura = new HashMap<>();

        for (Calificacion calif : calificaciones) {
            String nombreAsignatura = calif.getAsignatura().getNombreAsignatura();
            String anioAcademico = calif.getAsignatura().getCurso().getIdAnio().getDescripcion();

            evolucionPorAsignatura.computeIfAbsent(nombreAsignatura, k -> {
                EvolucionAcademicaDTO dto = new EvolucionAcademicaDTO();
                dto.setAsignatura(nombreAsignatura);
                dto.setCalificacionesPorAnio(new TreeMap<>()); // TreeMap para mantener orden
                return dto;
            });

            evolucionPorAsignatura.get(nombreAsignatura)
                    .getCalificacionesPorAnio()
                    .put(anioAcademico, calif.getCalificacion());
        }

        return new ArrayList<>(evolucionPorAsignatura.values());
    }
}
