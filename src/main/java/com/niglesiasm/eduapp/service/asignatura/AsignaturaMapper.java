package com.niglesiasm.eduapp.service.asignatura;

import com.niglesiasm.eduapp.model.Asignatura;

import java.util.List;
import java.util.Set;

public interface AsignaturaMapper {

    AsignaturaDTO asignaturaToAsignaturaDTO(Asignatura asignatura);

    List<AsignaturaDTO> asignaturasToAsignaturasDTO(Set<Asignatura> asignaturas);

    Asignatura asignaturaDTOToAsignatura(AsignaturaDTO asignaturaDTO);

    List<Asignatura> asignaturasDTOToAsignaturas(List<AsignaturaDTO> asignaturasDTO);
}
