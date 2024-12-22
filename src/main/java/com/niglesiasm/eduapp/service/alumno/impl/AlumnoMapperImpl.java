package com.niglesiasm.eduapp.service.alumno.impl;

import com.niglesiasm.eduapp.config.PaisProperties;
import com.niglesiasm.eduapp.model.Alumno;
import com.niglesiasm.eduapp.service.alumno.AlumnoDTO;
import com.niglesiasm.eduapp.service.alumno.AlumnoMapper;
import com.niglesiasm.eduapp.service.alumnoambito.AlumnoAmbitoDTO;
import com.niglesiasm.eduapp.service.alumnoambito.AlumnoAmbitoMapper;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaMapper;
import com.niglesiasm.eduapp.service.idioma.AlumnoIdiomaDTO;
import com.niglesiasm.eduapp.service.idioma.AlumnoIdiomaMapper;
import com.niglesiasm.eduapp.service.necesidadEspecial.NecesidadEspecialDTO;
import com.niglesiasm.eduapp.service.necesidadEspecial.NecesidadEspecialMapper;
import com.niglesiasm.eduapp.service.persona.PersonaDTO;
import com.niglesiasm.eduapp.service.persona.PersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoMapperImpl implements AlumnoMapper {

    private final PersonaMapper personaMapper;
    private final AsignaturaMapper asignaturaMapper;
    private final NecesidadEspecialMapper necesidadEspecialMapper;
    private final PaisProperties paisProperties;
    private final AlumnoIdiomaMapper alumnoIdiomaMapper;
    private final AlumnoAmbitoMapper alumnoAmbitoMapper;

    @Autowired
    public AlumnoMapperImpl(PersonaMapper personaMapper, AsignaturaMapper asignaturaMapper, NecesidadEspecialMapper necesidadEspecialMapper, PaisProperties paisProperties, AlumnoIdiomaMapper alumnoIdiomaMapper, AlumnoAmbitoMapper alumnoAmbitoMapper) {
        this.personaMapper = personaMapper;
        this.asignaturaMapper = asignaturaMapper;
        this.necesidadEspecialMapper = necesidadEspecialMapper;
        this.paisProperties = paisProperties;
        this.alumnoIdiomaMapper = alumnoIdiomaMapper;
        this.alumnoAmbitoMapper = alumnoAmbitoMapper;
    }

    @Override
    public AlumnoDTO alumnoToAlumnoDTO(Alumno entity) {
        if (entity == null) {
            return null;
        }

        AlumnoDTO alumnoDTO = new AlumnoDTO();

        alumnoDTO.setId(entity.getId());
        alumnoDTO.setNumeroExpediente(entity.getNumeroExpediente());

        PersonaDTO personaDTO = personaMapper.personaToPersonaDTO(entity.getPersona());
        alumnoDTO.setPersonaDTO(personaDTO);

        List<AsignaturaDTO> asignaturas = this.asignaturaMapper.asignaturasToAsignaturasDTO(entity.getAsignaturas());
        alumnoDTO.setAsignaturas(asignaturas);

        List<NecesidadEspecialDTO> necesidadesEspeciales = this.necesidadEspecialMapper.necesidadesEspecialesToNecesidadesEspecialesDTO(entity.getNecesidadesEspeciales());
        alumnoDTO.setNecesidadesEspeciales(necesidadesEspeciales);

        boolean esExtranjero = (entity.getNacionalidad() != null) && !(entity.getNacionalidad().getId().equals(this.paisProperties.getDefaultPais()));
        alumnoDTO.setExtranjero(esExtranjero);
        alumnoDTO.setNacionalidad(entity.getNacionalidad() != null ? entity.getNacionalidad().getNombre() : "");

        List<AlumnoIdiomaDTO> idiomas = this.alumnoIdiomaMapper.alumnosIdiomasToAlumnosIdiomasDTO(entity.getIdiomas());
        alumnoDTO.setIdiomas(idiomas);

        List<AlumnoAmbitoDTO> ambitos = this.alumnoAmbitoMapper.alumnosAmbitoToAlumnosAmbitoDTO(entity.getAmbitos());
        alumnoDTO.setAmbitos(ambitos);
        return alumnoDTO;
    }

    @Override
    public List<AlumnoDTO> alumnosToAlumnosDTO(List<Alumno> entityList) {
        if (entityList == null) {
            return new ArrayList<>();
        }

        List<AlumnoDTO> list = new ArrayList<>(entityList.size());
        for (Alumno alumno : entityList) {
            list.add(alumnoToAlumnoDTO(alumno));
        }

        return list;
    }

}
