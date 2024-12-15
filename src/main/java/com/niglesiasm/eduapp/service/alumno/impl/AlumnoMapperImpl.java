package com.niglesiasm.eduapp.service.alumno.impl;

import com.niglesiasm.eduapp.model.Alumno;
import com.niglesiasm.eduapp.service.alumno.AlumnoDTO;
import com.niglesiasm.eduapp.service.alumno.AlumnoMapper;
import com.niglesiasm.eduapp.service.persona.PersonaDTO;
import com.niglesiasm.eduapp.service.persona.PersonaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoMapperImpl implements AlumnoMapper {

    private final PersonaMapper personaMapper;

    @Autowired
    public AlumnoMapperImpl(PersonaMapper personaMapper) {
        this.personaMapper = personaMapper;
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


        return alumnoDTO;
    }

   /*  @Override
     public Alumno toAlumno(AlumnoDTO dto) {
         if ( dto == null ) {
             return null;
         }

         Alumno alumno = new Alumno();

         alumno.setId( dto.getId() );
         alumno.setNumeroExpediente( dto.getNumeroExpediente() );

         return alumno;
     }*/

    @Override
    public List<AlumnoDTO> alumnosToAlumnosDTO(List<Alumno> entityList) {
        if (entityList == null) {
            return null;
        }

        List<AlumnoDTO> list = new ArrayList<AlumnoDTO>(entityList.size());
        for (Alumno alumno : entityList) {
            list.add(alumnoToAlumnoDTO(alumno));
        }

        return list;
    }

    /* @Override
     public List<Alumno> toAlumnoList(List<AlumnoDTO> dtoList) {
         if ( dtoList == null ) {
             return null;
         }

         List<Alumno> list = new ArrayList<Alumno>( dtoList.size() );
         for ( AlumnoDTO alumnoDTO : dtoList ) {
             list.add( toAlumno( alumnoDTO ) );
         }

         return list;
     }
    */

}
