package com.niglesiasm.eduapp.service.idioma.impl;

import com.niglesiasm.eduapp.model.Idioma;
import com.niglesiasm.eduapp.repository.idioma.IdiomaDao;
import com.niglesiasm.eduapp.service.idioma.IdiomaDTO;
import com.niglesiasm.eduapp.service.idioma.IdiomaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class IdiomaMapperImpl implements IdiomaMapper {

    private final IdiomaDao idiomaDao;

    @Autowired
    public IdiomaMapperImpl(IdiomaDao idiomaDao) {
        this.idiomaDao = idiomaDao;
    }

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


    @Override
    public Idioma idiomaDTOToIdioma(IdiomaDTO idiomaDTO) {
        if (idiomaDTO == null) {
            return null;
        }
        Optional<Idioma> optionalIdioma = this.idiomaDao.findByNombre(idiomaDTO.getNombreIdioma());

        if (optionalIdioma.isPresent()) {
            return optionalIdioma.get();
        } else {
            Idioma idioma = new Idioma();
            idioma.setNombre(idiomaDTO.getNombreIdioma());
            return idiomaDao.save(idioma);
        }

    }

    @Override
    public Set<Idioma> idiomasDTOToIdiomas(List<IdiomaDTO> idiomasDTO) {
        return idiomasDTO.stream().map(this::idiomaDTOToIdioma).collect(java.util.stream.Collectors.toSet());
    }
}
