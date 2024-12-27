package com.niglesiasm.eduapp.service.alumno;

import com.niglesiasm.eduapp.service.alumnoambito.AlumnoAmbitoDTO;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;
import com.niglesiasm.eduapp.service.idioma.AlumnoIdiomaDTO;
import com.niglesiasm.eduapp.service.necesidadespecial.NecesidadEspecialDTO;
import com.niglesiasm.eduapp.service.persona.PersonaDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AlumnoDTO {

    private Integer id;
    private Long numeroExpediente;
    private PersonaDTO persona;
    private List<AsignaturaDTO> asignaturas;
    private List<NecesidadEspecialDTO> necesidadesEspeciales;
    private List<AlumnoIdiomaDTO> idiomas;
    private List<AlumnoAmbitoDTO> ambitos;
    private Boolean extranjero;
    private String nacionalidad;

}
