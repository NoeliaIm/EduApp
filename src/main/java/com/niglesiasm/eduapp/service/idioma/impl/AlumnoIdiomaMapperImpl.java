package com.niglesiasm.eduapp.service.idioma.impl;

import com.niglesiasm.eduapp.model.AlumnoIdioma;
import com.niglesiasm.eduapp.model.AlumnoIdiomaId;
import com.niglesiasm.eduapp.model.NivelIdioma;
import com.niglesiasm.eduapp.repository.alumnoidioma.AlumnoIdiomaDao;
import com.niglesiasm.eduapp.service.idioma.AlumnoIdiomaDTO;
import com.niglesiasm.eduapp.service.idioma.AlumnoIdiomaMapper;
import com.niglesiasm.eduapp.service.idioma.IdiomaDTO;
import com.niglesiasm.eduapp.service.idioma.IdiomaMapper;
import com.niglesiasm.eduapp.service.niveles.NivelIdiomaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AlumnoIdiomaMapperImpl implements AlumnoIdiomaMapper {

    private final IdiomaMapper idiomaMapper;

    private final AlumnoIdiomaDao alumnoIdiomaDao;

    @Autowired
    public AlumnoIdiomaMapperImpl(IdiomaMapper idiomaMapper, AlumnoIdiomaDao alumnoIdiomaDao) {
        this.idiomaMapper = idiomaMapper;
        this.alumnoIdiomaDao = alumnoIdiomaDao;
    }

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

    @Override
    public AlumnoIdioma alumnoIdiomaDTOToAlumnoIdioma(AlumnoIdiomaDTO alumnoIdiomaDTO) {

        AlumnoIdioma alumnoIdioma = new AlumnoIdioma();
        // Crear y establecer el ID compuesto
        AlumnoIdiomaId id = new AlumnoIdiomaId();
        id.setIdioma(this.idiomaMapper.idiomaDTOToIdioma(alumnoIdiomaDTO.getIdioma()));
        alumnoIdioma.setId(id);

        // Establecer el resto de propiedades
        alumnoIdioma.setEsNativo(alumnoIdiomaDTO.isNativo());

        NivelIdioma nivelIdioma = new NivelIdioma();
        nivelIdioma.setId(alumnoIdiomaDTO.getNivelIdioma().getIdNivelIdioma());
        nivelIdioma.setDescripcion(alumnoIdiomaDTO.getNivelIdioma().getNombreNivelIdioma());
        alumnoIdioma.setNivelIdioma(nivelIdioma);

        return alumnoIdioma;
    }

    @Override
    public Set<AlumnoIdioma> alumnosIdiomasDTOToAlumnosIdiomas(List<AlumnoIdiomaDTO> alumnosIdiomasDTO) {
        return alumnosIdiomasDTO.stream().map(this::alumnoIdiomaDTOToAlumnoIdioma).collect(java.util.stream.Collectors.toSet());
    }
}
