package com.niglesiasm.eduapp.service.alumnoambito;

import com.niglesiasm.eduapp.service.niveles.NivelAcademicoDTO;
import lombok.Data;

@Data
public class AlumnoAmbitoDTO {

    private AmbitoDTO ambito;
    private NivelAcademicoDTO nivelAcademico;
}
