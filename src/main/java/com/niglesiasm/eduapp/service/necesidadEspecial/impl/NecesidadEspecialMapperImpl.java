package com.niglesiasm.eduapp.service.necesidadEspecial.impl;

import com.niglesiasm.eduapp.model.NecesidadEspecial;
import com.niglesiasm.eduapp.service.necesidadEspecial.NecesidadEspecialDTO;
import com.niglesiasm.eduapp.service.necesidadEspecial.NecesidadEspecialMapper;
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
}
