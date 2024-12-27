package com.niglesiasm.eduapp.service.necesidadespecial.impl;

import com.niglesiasm.eduapp.model.NecesidadEspecial;
import com.niglesiasm.eduapp.service.necesidadespecial.NecesidadEspecialDTO;
import com.niglesiasm.eduapp.service.necesidadespecial.NecesidadEspecialMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class NecesidadEspecialMapperImpl implements NecesidadEspecialMapper {

    @Override
    public NecesidadEspecialDTO necesidadEspecialToNecesidadEspecialDTO(NecesidadEspecial necesidadEspecial) {
        NecesidadEspecialDTO necesidadEspecialDTO = new NecesidadEspecialDTO();
        necesidadEspecialDTO.setIdNecesidadEspecial(necesidadEspecial.getId());
        necesidadEspecialDTO.setNombreNecesidadEspecial(necesidadEspecial.getDescripcion());
        return necesidadEspecialDTO;
    }

    @Override
    public List<NecesidadEspecialDTO> necesidadesEspecialesToNecesidadesEspecialesDTO(Set<NecesidadEspecial> necesidadesEspeciales) {
        List<NecesidadEspecialDTO> necesidadEspecialDTOS = new ArrayList<>(necesidadesEspeciales.size());
        for (NecesidadEspecial necesidadEspecial : necesidadesEspeciales) {
            necesidadEspecialDTOS.add(necesidadEspecialToNecesidadEspecialDTO(necesidadEspecial));
        }
        return necesidadEspecialDTOS;
    }

    @Override
    public NecesidadEspecial necesidadEspecialDTOToNecesidadEspecial(NecesidadEspecialDTO necesidadEspecialDTO) {
        if (necesidadEspecialDTO == null) {
            return null;
        }
        NecesidadEspecial necesidadEspecial = new NecesidadEspecial();
        necesidadEspecial.setId(necesidadEspecialDTO.getIdNecesidadEspecial());
        necesidadEspecial.setDescripcion(necesidadEspecialDTO.getNombreNecesidadEspecial());
        return necesidadEspecial;
    }

    @Override
    public Set<NecesidadEspecial> necesidadesEspecialesDTOToNecesidadesEspeciales(List<NecesidadEspecialDTO> necesidadesEspecialesDTO) {
        return necesidadesEspecialesDTO.stream().map(this::necesidadEspecialDTOToNecesidadEspecial).collect(java.util.stream.Collectors.toSet());
    }
}

