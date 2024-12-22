package com.niglesiasm.eduapp.service.niveles.impl;

import com.niglesiasm.eduapp.model.NivelIdioma;
import com.niglesiasm.eduapp.repository.niveles.NivelIdiomaDao;
import com.niglesiasm.eduapp.service.niveles.NivelIdiomaDTO;
import com.niglesiasm.eduapp.service.niveles.NivelIdiomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NivelIdiomaServiceImpl implements NivelIdiomaService {

    private final NivelIdiomaDao nivelIdiomaDao;

    @Autowired
    public NivelIdiomaServiceImpl(NivelIdiomaDao nivelIdiomaDao) {
        this.nivelIdiomaDao = nivelIdiomaDao;
    }

    @Override
    public List<NivelIdiomaDTO> getAllNivelesIdioma() {
        List<NivelIdioma> nivelIdioma = this.nivelIdiomaDao.findAll();
        List<NivelIdiomaDTO> nivelesIdiomaDto = new ArrayList<>(nivelIdioma.size());
        for (NivelIdioma nivel : nivelIdioma) {
            NivelIdiomaDTO nivelIdiomaDTO = new NivelIdiomaDTO();
            nivelIdiomaDTO.setIdNivelIdioma(nivel.getId());
            nivelIdiomaDTO.setNombreNivelIdioma(nivel.getDescripcion());
            nivelesIdiomaDto.add(nivelIdiomaDTO);
        }
        return nivelesIdiomaDto;
    }
}
