package com.niglesiasm.eduapp.service.asignatura.impl;

import com.niglesiasm.eduapp.model.Asignatura;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AsignaturaMapperImpl implements AsignaturaMapper {

    @Override
    public AsignaturaDTO asignaturaToAsignaturaDTO(Asignatura asignatura) {
        AsignaturaDTO asignaturaDTO = new AsignaturaDTO();
        asignaturaDTO.setIdAsignatura(asignatura.getId());
        asignaturaDTO.setNombreAsignatura(asignatura.getNombreAsignatura());
        asignaturaDTO.setDescripcion(asignatura.getDescripcion());
        asignaturaDTO.setAcron(asignatura.getAcron());
        asignaturaDTO.setNombreCurso(asignatura.getIdCurso().getNombreCurso()); // TODO: cambiar nombrea  a curso en la entidad
        return asignaturaDTO;
    }

    @Override
    public List<AsignaturaDTO> asignaturasToAsignaturasDTO(Set<Asignatura> asignaturas) {
        List<AsignaturaDTO> asignaturaDTOS = new ArrayList<>(asignaturas.size());
        for (Asignatura asignatura : asignaturas) {
            asignaturaDTOS.add(asignaturaToAsignaturaDTO(asignatura));
        }
        return asignaturaDTOS;
    }
}
