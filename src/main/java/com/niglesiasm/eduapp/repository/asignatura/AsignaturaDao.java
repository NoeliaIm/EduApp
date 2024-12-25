package com.niglesiasm.eduapp.repository.asignatura;

import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;

import java.util.List;

public interface AsignaturaDao {

    List<AsignaturaDTO> obtenerAsignaturasByAnnioActual();

}
