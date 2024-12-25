package com.niglesiasm.eduapp.service.idioma;

import com.niglesiasm.eduapp.model.Idioma;

import java.util.List;
import java.util.Set;

public interface IdiomaMapper {

    IdiomaDTO idiomaToIdiomaDTO(Idioma idioma);

    List<IdiomaDTO> idiomasToIdiomasDTO(Set<Idioma> idiomas);
}
