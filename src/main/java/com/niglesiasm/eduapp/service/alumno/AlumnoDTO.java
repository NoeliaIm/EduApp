package com.niglesiasm.eduapp.service.alumno;

import com.niglesiasm.eduapp.service.alumnoambito.AmbitoDTO;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;
import com.niglesiasm.eduapp.service.idioma.IdiomaDTO;
import com.niglesiasm.eduapp.service.necesidadEspecial.NecesidadEspecialDTO;
import com.niglesiasm.eduapp.service.persona.PersonaDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AlumnoDTO {

    private Integer id;
    private Long numeroExpediente;
    private PersonaDTO personaDTO;
    private List<AsignaturaDTO> asignaturas;
    private List<NecesidadEspecialDTO> necesidadesEspeciales;
    private List<IdiomaDTO> idiomas;
    private List<AmbitoDTO> ambitos;

}
