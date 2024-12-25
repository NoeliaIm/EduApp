package com.niglesiasm.eduapp.service.idioma.impl;

import com.niglesiasm.eduapp.model.Idioma;
import com.niglesiasm.eduapp.service.idioma.IdiomaDTO;
import com.niglesiasm.eduapp.service.idioma.IdiomaMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class IdiomaMapperImpl implements IdiomaMapper {
    @Override
    public IdiomaDTO idiomaToIdiomaDTO(Idioma idioma) {
        IdiomaDTO idiomaDTO = new IdiomaDTO();
        idiomaDTO.setIdIdioma(idioma.getId());
        idiomaDTO.setNombreIdioma(idioma.getNombre());
        return idiomaDTO;
    }

    @Override
    public List<IdiomaDTO> idiomasToIdiomasDTO(Set<Idioma> idiomas) {
        List<IdiomaDTO> idiomaDTOS = new ArrayList<>(idiomas.size());
        for (Idioma idioma : idiomas) {
            idiomaDTOS.add(idiomaToIdiomaDTO(idioma));
        }
        return idiomaDTOS;
    }
}
