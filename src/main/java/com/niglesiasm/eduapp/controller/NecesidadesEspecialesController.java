package com.niglesiasm.eduapp.controller;

import com.niglesiasm.eduapp.service.necesidadespecial.NecesidadEspecialDTO;
import com.niglesiasm.eduapp.service.necesidadespecial.NecesidadEspecialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/necesidadesEspeciales")
public class NecesidadesEspecialesController {

    private final NecesidadEspecialService necesidadEspecialService;

    @Autowired
    public NecesidadesEspecialesController(NecesidadEspecialService necesidadEspecialService) {
        this.necesidadEspecialService = necesidadEspecialService;
    }

    @GetMapping
    public List<NecesidadEspecialDTO> getAll() {
        return this.necesidadEspecialService.getAllNecesidadesEspeciales();
    }
}
