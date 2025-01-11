package com.niglesiasm.eduapp.service.calificacion;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class EvolucionAcademicaDTO {

    private String asignatura;
    private Map<String, BigDecimal> calificacionesPorAnio;
    private Integer consultasPorAsignatura = 0;

}
