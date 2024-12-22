package com.niglesiasm.eduapp.service.idioma;

import com.niglesiasm.eduapp.service.niveles.NivelIdiomaDTO;
import lombok.Data;

@Data
public class AlumnoIdiomaDTO {

    private boolean isNativo;
    private NivelIdiomaDTO nivelIdioma;
    private IdiomaDTO idioma;
}
