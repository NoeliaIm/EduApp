package com.niglesiasm.eduapp.service.niveles.impl;

import com.niglesiasm.eduapp.model.NivelAcademico;
import com.niglesiasm.eduapp.repository.niveles.NivelAcademicoDao;
import com.niglesiasm.eduapp.service.niveles.NivelAcademicoDTO;
import com.niglesiasm.eduapp.service.niveles.NivelAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NivelAcademicoServiceImpl implements NivelAcademicoService {

    private final NivelAcademicoDao nivelAcademicoDao;

    @Autowired
    public NivelAcademicoServiceImpl(NivelAcademicoDao nivelAcademicoDao) {
        this.nivelAcademicoDao = nivelAcademicoDao;
    }

    @Override
    public List<NivelAcademicoDTO> getAllNivelesAcademicos() {
        List<NivelAcademico> nivelesAcademicos = nivelAcademicoDao.findAll();
        List<NivelAcademicoDTO> nivelAcademicoDTOS = new ArrayList<>(nivelesAcademicos.size());
        for (NivelAcademico nivelAcademico : nivelesAcademicos) {
            NivelAcademicoDTO nivelAcademicoDTO = new NivelAcademicoDTO();
            nivelAcademicoDTO.setIdNivelAcademico(nivelAcademico.getId());
            nivelAcademicoDTO.setNombreNivelAcademico(nivelAcademico.getDescripcion());
            nivelAcademicoDTOS.add(nivelAcademicoDTO);
        }
        return nivelAcademicoDTOS;
    }
}
