package com.niglesiasm.eduapp.service.idioma.impl;

import com.niglesiasm.eduapp.model.AlumnoIdioma;
import com.niglesiasm.eduapp.service.idioma.AlumnoIdiomaDTO;
import com.niglesiasm.eduapp.service.idioma.AlumnoIdiomaMapper;
import com.niglesiasm.eduapp.service.idioma.IdiomaDTO;
import com.niglesiasm.eduapp.service.niveles.NivelIdiomaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AlumnoIdiomaMapperImpl implements AlumnoIdiomaMapper {

    @Override
    public AlumnoIdiomaDTO alumnoIdiomaToAlumnoIdiomaDTO(AlumnoIdioma alumnoIdioma) {
        AlumnoIdiomaDTO alumnoIdiomaDTO = new AlumnoIdiomaDTO();
        NivelIdiomaDTO nivelIdiomaDTO = new NivelIdiomaDTO();
        IdiomaDTO idiomaDTO = new IdiomaDTO();
        idiomaDTO.setIdIdioma(alumnoIdioma.getId().getIdioma().getId());
        idiomaDTO.setNombreIdioma(alumnoIdioma.getId().getIdioma().getNombre());
        alumnoIdiomaDTO.setIdioma(idiomaDTO);
        nivelIdiomaDTO.setIdNivelIdioma(alumnoIdioma.getNivelIdioma().getId());
        nivelIdiomaDTO.setNombreNivelIdioma(alumnoIdioma.getNivelIdioma().getDescripcion());
        alumnoIdiomaDTO.setNivelIdioma(nivelIdiomaDTO);
        alumnoIdiomaDTO.setNativo(alumnoIdioma.getEsNativo());
        return alumnoIdiomaDTO;
    }

    @Override
    public List<AlumnoIdiomaDTO> alumnosIdiomasToAlumnosIdiomasDTO(Set<AlumnoIdioma> alumnosIdiomas) {
        List<AlumnoIdiomaDTO> alumnoIdiomaDTOS = new ArrayList<>(alumnosIdiomas.size());
        for (AlumnoIdioma alumnoIdioma : alumnosIdiomas) {
            alumnoIdiomaDTOS.add(alumnoIdiomaToAlumnoIdiomaDTO(alumnoIdioma));
        }
        return alumnoIdiomaDTOS;
    }
}
