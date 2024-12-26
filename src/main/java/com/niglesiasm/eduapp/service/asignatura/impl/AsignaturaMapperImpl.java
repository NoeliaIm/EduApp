package com.niglesiasm.eduapp.service.asignatura.impl;

import com.niglesiasm.eduapp.model.Asignatura;
import com.niglesiasm.eduapp.model.Curso;
import com.niglesiasm.eduapp.repository.curso.CursoDao;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AsignaturaMapperImpl implements AsignaturaMapper {


    private final CursoDao cursoDao;

    @Autowired
    public AsignaturaMapperImpl(CursoDao cursoDao) {
        this.cursoDao = cursoDao;
    }

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

    @Override
    public Asignatura asignaturaDTOToAsignatura(AsignaturaDTO asignaturaDTO) {
        if (asignaturaDTO == null) {
            return null;
        }
        Asignatura asignatura = new Asignatura();
        asignatura.setId(asignaturaDTO.getIdAsignatura());
        asignatura.setNombreAsignatura(asignaturaDTO.getNombreAsignatura());
        asignatura.setDescripcion(asignaturaDTO.getDescripcion());
        asignatura.setAcron(asignaturaDTO.getAcron());
        Curso curso = this.cursoDao.findById(asignaturaDTO.getIdCurso()).orElseThrow();
        asignatura.setIdCurso(curso);
        return asignatura;
    }


    @Override
    public List<Asignatura> asignaturasDTOToAsignaturas(List<AsignaturaDTO> asignaturaDTOs) {
        if (asignaturaDTOs == null) {
            return null;
        }
        List<Asignatura> list = new ArrayList<>(asignaturaDTOs.size());
        for (AsignaturaDTO asignaturaDTO : asignaturaDTOs) {
            list.add(asignaturaDTOToAsignatura(asignaturaDTO));
        }
        return list;
    }
}
