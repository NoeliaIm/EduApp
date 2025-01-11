package com.niglesiasm.eduapp.service.calificacion;

import java.util.List;

public interface CalificacionService {

    List<EvolucionAcademicaDTO> getCalificacionesByAlumno(Integer idAlumno);
}
