package com.niglesiasm.eduapp.service.necesidadespecial.impl;

import com.niglesiasm.eduapp.model.NecesidadEspecial;
import com.niglesiasm.eduapp.repository.necesidadespecial.NecesidadEspecialDao;
import com.niglesiasm.eduapp.service.necesidadespecial.NecesidadEspecialDTO;
import com.niglesiasm.eduapp.service.necesidadespecial.NecesidadEspecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NecesidadEspecialServiceImpl implements NecesidadEspecialService {


    private final NecesidadEspecialDao necesidadEspecialDao;

    @Autowired
    public NecesidadEspecialServiceImpl(NecesidadEspecialDao necesidadEspecialDao) {
        this.necesidadEspecialDao = necesidadEspecialDao;
    }

    @Override
    public List<NecesidadEspecialDTO> getAllNecesidadesEspeciales() {

        List<NecesidadEspecial> necesidadEspeciales = this.necesidadEspecialDao.findAll();
        List<NecesidadEspecialDTO> necesidadEspecialDTOS = new ArrayList<>(necesidadEspeciales.size());
        for (NecesidadEspecial necesidadEspecial : necesidadEspeciales) {
            NecesidadEspecialDTO necesidadEspecialDTO = new NecesidadEspecialDTO();
            necesidadEspecialDTO.setIdNecesidadEspecial(necesidadEspecial.getId());
            necesidadEspecialDTO.setNombreNecesidadEspecial(necesidadEspecial.getDescripcion());
            necesidadEspecialDTOS.add(necesidadEspecialDTO);
        }

        return necesidadEspecialDTOS;
    }
}
