package com.niglesiasm.eduapp.repository.asignatura;

import com.niglesiasm.eduapp.model.Asignatura;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;

import java.util.List;

public interface AsignaturaDao {

    List<AsignaturaDTO> obtenerAsignaturasByAnnioActual();

    void guardarAsignatura(Asignatura asignatura);

    Asignatura findByIdAsignatura(Integer id);

}
