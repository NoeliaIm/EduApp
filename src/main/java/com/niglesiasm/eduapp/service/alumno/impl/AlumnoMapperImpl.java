package com.niglesiasm.eduapp.service.alumno.impl;

import com.niglesiasm.eduapp.config.PaisProperties;
import com.niglesiasm.eduapp.model.Alumno;
import com.niglesiasm.eduapp.model.Nacionalidad;
import com.niglesiasm.eduapp.repository.nacionalidad.NacionalidadDao;
import com.niglesiasm.eduapp.service.alumno.AlumnoDTO;
import com.niglesiasm.eduapp.service.alumno.AlumnoMapper;
import com.niglesiasm.eduapp.service.alumnoambito.AlumnoAmbitoDTO;
import com.niglesiasm.eduapp.service.alumnoambito.AlumnoAmbitoMapper;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaMapper;
import com.niglesiasm.eduapp.service.idioma.AlumnoIdiomaDTO;
import com.niglesiasm.eduapp.service.idioma.AlumnoIdiomaMapper;
import com.niglesiasm.eduapp.service.necesidadespecial.NecesidadEspecialDTO;
import com.niglesiasm.eduapp.service.necesidadespecial.NecesidadEspecialMapper;
import com.niglesiasm.eduapp.service.persona.PersonaDTO;
import com.niglesiasm.eduapp.service.persona.PersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoMapperImpl implements AlumnoMapper {

    private final PersonaMapper personaMapper;
    private final AsignaturaMapper asignaturaMapper;
    private final NecesidadEspecialMapper necesidadEspecialMapper;
    private final PaisProperties paisProperties;
    private final AlumnoIdiomaMapper alumnoIdiomaMapper;
    private final AlumnoAmbitoMapper alumnoAmbitoMapper;
    private final NacionalidadDao nacionalidadDao;

    @Autowired
    public AlumnoMapperImpl(PersonaMapper personaMapper, AsignaturaMapper asignaturaMapper, NecesidadEspecialMapper necesidadEspecialMapper, PaisProperties paisProperties, AlumnoIdiomaMapper alumnoIdiomaMapper, AlumnoAmbitoMapper alumnoAmbitoMapper, NacionalidadDao nacionalidadDao) {
        this.personaMapper = personaMapper;
        this.asignaturaMapper = asignaturaMapper;
        this.necesidadEspecialMapper = necesidadEspecialMapper;
        this.paisProperties = paisProperties;
        this.alumnoIdiomaMapper = alumnoIdiomaMapper;
        this.alumnoAmbitoMapper = alumnoAmbitoMapper;
        this.nacionalidadDao = nacionalidadDao;
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
        alumnoDTO.setPersona(personaDTO);

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


    @Override
    public Alumno alumnoDTOToAlumno(AlumnoDTO alumnoDTO) {
        if (alumnoDTO == null) {
            return null;
        }
        if (alumnoDTO.getPersona() == null) {
            return null;
        }
        Alumno alumno = new Alumno();
        alumno.setId(alumnoDTO.getId());
        alumno.setNumeroExpediente(alumnoDTO.getNumeroExpediente());
        alumno.setAsignaturas(new HashSet<>(this.asignaturaMapper.asignaturasDTOToAsignaturas(alumnoDTO.getAsignaturas())));
        alumno.setNecesidadesEspeciales(this.necesidadEspecialMapper.necesidadesEspecialesDTOToNecesidadesEspeciales(alumnoDTO.getNecesidadesEspeciales()));
        Optional<Nacionalidad> nacionalidad;
        if (Boolean.FALSE.equals(alumnoDTO.getExtranjero())) {
            nacionalidad = this.nacionalidadDao.findById(this.paisProperties.getDefaultPais());
        } else {
            nacionalidad = this.nacionalidadDao.findByNombre(alumnoDTO.getNacionalidad());
        }
        nacionalidad.ifPresent(alumno::setNacionalidad);
        if (nacionalidad.isPresent()) {
            return alumno;
        }
        Nacionalidad newNacionalidad = new Nacionalidad();
        newNacionalidad.setNombre(alumnoDTO.getNacionalidad());
        alumno.setNacionalidad(newNacionalidad);
        return alumno;
    }
}
