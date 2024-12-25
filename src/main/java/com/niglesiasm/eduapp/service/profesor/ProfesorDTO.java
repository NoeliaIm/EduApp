package com.niglesiasm.eduapp.service.profesor;

import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;
import com.niglesiasm.eduapp.service.persona.PersonaDTO;
import lombok.Data;

import java.util.List;

@Data
public class ProfesorDTO {

    private Integer idProfesor;
    private PersonaDTO persona;
    private List<AsignaturaDTO> asignaturas;
}
