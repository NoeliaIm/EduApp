package com.niglesiasm.eduapp.service.asignatura;

import com.niglesiasm.eduapp.model.Asignatura;

import java.util.List;
import java.util.Optional;

public interface AsignaturaService {


    List<AsignaturaDTO> getAsignaturasAll();

    Optional<AsignaturaDTO> findById(Integer id);

    Asignatura save(Asignatura entity);

    void deleteById(Integer id);
}
