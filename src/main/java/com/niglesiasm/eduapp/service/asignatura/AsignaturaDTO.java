package com.niglesiasm.eduapp.service.asignatura;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaDTO {

    private Integer idAsignatura;
    private String nombreAsignatura;
    private String nombreCurso;
    private String descripcion;
    private String acron;
}
