package com.niglesiasm.eduapp.service.asignatura;

import java.util.List;
import java.util.Optional;

public interface AsignaturaService {


    List<AsignaturaDTO> getAsignaturasAll();

    Optional<AsignaturaDTO> findById(Integer id);

    void createOrUpdateAsignatura(AsignaturaDTO asignaturaDTO);

    void deleteById(Integer id);
}
