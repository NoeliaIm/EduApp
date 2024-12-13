package com.niglesiasm.eduapp.service.alumno;

import com.niglesiasm.eduapp.model.*;
import com.niglesiasm.eduapp.service.persona.PersonaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Data
public class AlumnoDTO extends PersonaDTO {

    private Integer id;
    private Persona persona;
    private Long numeroExpediente;
    private Nacionalidad nacionalidad;
    private Set<Asignatura> asignaturas;
    private Curso curso;
    private Set<Idioma> idiomas;
    private Set<AlumnoAmbito> alumnoAmbitos;
    private Set<NecesidadEspecial> necesidadesEspeciales;


    public static AlumnoDTO fromEntity(Alumno alumno) {
        AlumnoDTO dto = new AlumnoDTO();
        // Datos de persona
        dto.setId(alumno.getPersona().getId());
        dto.setNombre(alumno.getPersona().getNombre());
        dto.setApellido1(alumno.getPersona().getApellido1());
        dto.setApellido2(alumno.getPersona().getApellido2());
        dto.setEmail(alumno.getPersona().getEmail());

        // Datos específicos de alumno
        dto.setNumeroExpediente(alumno.getNumeroExpediente());
        if (alumno.getNacionalidad() != null) {
            dto.setNacionalidad(alumno.getNacionalidad());
        }
        if (alumno.getCurso() != null) {
            dto.setCurso(alumno.getCurso());
        }

        // Convertir colecciones
        dto.setAsignaturas(new HashSet<>(alumno.getAsignaturas()));

        dto.setNecesidadesEspeciales(new HashSet<>(alumno.getNecesidadesEspeciales()));

        return dto;
    }

}
