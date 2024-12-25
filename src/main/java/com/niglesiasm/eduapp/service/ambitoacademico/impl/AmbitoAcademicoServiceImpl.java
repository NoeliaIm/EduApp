package com.niglesiasm.eduapp.service.ambitoacademico.impl;

import com.niglesiasm.eduapp.model.AmbitoAcademico;
import com.niglesiasm.eduapp.repository.ambitoacademico.AmbitoAcademicoDao;
import com.niglesiasm.eduapp.service.ambitoacademico.AmbitoAcademicoDTO;
import com.niglesiasm.eduapp.service.ambitoacademico.AmbitoAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmbitoAcademicoServiceImpl implements AmbitoAcademicoService {

    private final AmbitoAcademicoDao ambitoAcademicoDao;

    @Autowired
    public AmbitoAcademicoServiceImpl(AmbitoAcademicoDao ambitoAcademicoDao) {
        this.ambitoAcademicoDao = ambitoAcademicoDao;
    }

    @Override
    public List<AmbitoAcademicoDTO> getAllAmbitosAcademicos() {
        List<AmbitoAcademico> ambitosAcademicos = ambitoAcademicoDao.findAll();
        List<AmbitoAcademicoDTO> ambitoAcademicoDTOS = new ArrayList<>(ambitosAcademicos.size());
        for (AmbitoAcademico ambitoAcademico : ambitosAcademicos) {
            AmbitoAcademicoDTO ambitoAcademicoDTO = new AmbitoAcademicoDTO();
            ambitoAcademicoDTO.setIdAmbitoAcademico(ambitoAcademico.getId());
            ambitoAcademicoDTO.setNombreAmbitoAcademico(ambitoAcademico.getNombre());
            ambitoAcademicoDTOS.add(ambitoAcademicoDTO);
        }
        return ambitoAcademicoDTOS;
    }
}
