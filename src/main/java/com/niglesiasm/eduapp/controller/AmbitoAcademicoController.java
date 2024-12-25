package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.service.ambitoacademico.AmbitoAcademicoDTO;
import com.niglesiasm.eduapp.service.ambitoacademico.AmbitoAcademicoService;
import com.niglesiasm.eduapp.service.niveles.NivelAcademicoDTO;
import com.niglesiasm.eduapp.service.niveles.NivelAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ambitoAcademico")
public class AmbitoAcademicoController {

    private AmbitoAcademicoService ambitoAcademicoService;
    private NivelAcademicoService nivelAcademicoService;

    @Autowired
    public AmbitoAcademicoController(AmbitoAcademicoService ambitoAcademicoService, NivelAcademicoService nivelAcademicoService) {
        this.ambitoAcademicoService = ambitoAcademicoService;
        this.nivelAcademicoService = nivelAcademicoService;
    }

    @GetMapping
    public List<AmbitoAcademicoDTO> getAll() {
        return ambitoAcademicoService.getAllAmbitosAcademicos();
    }

    @GetMapping("/niveles")
    public List<NivelAcademicoDTO> getAllNiveles() {
        return nivelAcademicoService.getAllNivelesAcademicos();
    }
}
