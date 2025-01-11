package com.niglesiasm.eduapp.service.alumno.impl;

import com.niglesiasm.eduapp.model.*;
import com.niglesiasm.eduapp.model.enums.Rol;
import com.niglesiasm.eduapp.repository.alumno.AlumnoDao;
import com.niglesiasm.eduapp.repository.niveles.NivelAcademicoDao;
import com.niglesiasm.eduapp.service.alumno.AlumnoDTO;
import com.niglesiasm.eduapp.service.alumno.AlumnoMapper;
import com.niglesiasm.eduapp.service.alumno.AlumnoService;
import com.niglesiasm.eduapp.service.alumnoambito.AlumnoAmbitoDTO;
import com.niglesiasm.eduapp.service.alumnoambito.AlumnoAmbitoMapper;
import com.niglesiasm.eduapp.service.idioma.AlumnoIdiomaDTO;
import com.niglesiasm.eduapp.service.idioma.AlumnoIdiomaMapper;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class AlumnoServiceImpl implements AlumnoService {


    private final AlumnoDao alumnoDao;
    private final AlumnoMapper alumnoMapper;
    private final AlumnoIdiomaMapper alumnoIdiomaMapper;
    private final AlumnoAmbitoMapper alumnoAmbitoMapper;
    private final NivelAcademicoDao nivelAcademicoDao;

    @Autowired
    AlumnoServiceImpl(AlumnoDao alumnoDao, AlumnoMapper alumnoMapper, AlumnoIdiomaMapper alumnoIdiomaMapper, AlumnoAmbitoMapper alumnoAmbitoMapper, EntityManager entityManager, NivelAcademicoDao nivelAcademicoDao) {
        this.alumnoDao = alumnoDao;
        this.alumnoMapper = alumnoMapper;
        this.alumnoIdiomaMapper = alumnoIdiomaMapper;
        this.alumnoAmbitoMapper = alumnoAmbitoMapper;
        this.nivelAcademicoDao = nivelAcademicoDao;
    }

    @Override
    public List<AlumnoDTO> getAlumnosAll() {
        List<Alumno> alumnoList = alumnoDao.getAlumnosAnnioEncurso();
        alumnoList = alumnoList.stream().filter(alumno -> alumno.getPersona().getFechaBaja() == null).toList();
        return alumnoMapper.alumnosToAlumnosDTO(alumnoList);
    }

    @Override
    public Optional<AlumnoDTO> findById(Integer id) {
        Optional<Alumno> alumno = alumnoDao.findById(id);

        if (alumno.isPresent()) {
            AlumnoDTO alumnoDTO = alumnoMapper.alumnoToAlumnoDTO(alumno.get());
            return Optional.of(alumnoDTO);
        }
        return Optional.empty();
    }

    @Override
    public Optional<AlumnoDTO> findByPersonaId(Integer id) {
        Optional<Alumno> alumno = alumnoDao.findByIdPersona(id);

        if (alumno.isPresent()) {
            AlumnoDTO alumnoDTO = alumnoMapper.alumnoToAlumnoDTO(alumno.get());
            return Optional.of(alumnoDTO);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void createOrUpdateAlumno(AlumnoDTO alumnoDTO) {

        // comprobaciones previas
        this.comprobarIdiomas(alumnoDTO);

        // comprobar nacionalidad
        this.comprobarNacionalidad(alumnoDTO);

        if (alumnoDTO.getPersona().getId() == null) {
            Persona persona = new Persona();
            persona.setNombre(alumnoDTO.getPersona().getNombre());
            persona.setApellido1(alumnoDTO.getPersona().getApellido1());
            persona.setApellido2(alumnoDTO.getPersona().getApellido2());
            persona.setEmail(alumnoDTO.getPersona().getEmail());
            persona.setFechaAlta(LocalDate.now());
            persona.setRoles(Set.of(Rol.ALUM));
            Alumno alumno = alumnoMapper.alumnoDTOToAlumno(alumnoDTO);
            alumno.setPersona(persona);
            Optional<Curso> cursoOptional = alumno.getAsignaturas().stream().findFirst().map(Asignatura::getCurso);
            cursoOptional.ifPresent(alumno::setCurso);

            Alumno alumnoPersist = this.alumnoDao.save(alumno);

            Set<AlumnoIdioma> idiomas = this.alumnoIdiomaMapper.alumnosIdiomasDTOToAlumnosIdiomas(alumnoDTO.getIdiomas());
            for (AlumnoIdioma idioma : idiomas) {
                AlumnoIdiomaId id = new AlumnoIdiomaId();
                id.setAlumno(alumnoPersist);
                id.setIdioma(idioma.getId().getIdioma());
                idioma.setId(id);
            }
            alumnoPersist.setIdiomas(idiomas);

            Set<AlumnoAmbito> ambitos = this.alumnoAmbitoMapper.alumnosAmbitoDTOToAlumnosAmbito(alumnoDTO.getAmbitos());
            for (AlumnoAmbito ambito : ambitos) {
                AlumnoAmbitoId id = new AlumnoAmbitoId();
                id.setAlumno(alumnoPersist);
                id.setAmbito(ambito.getId().getAmbito());
                ambito.setId(id);
            }
            alumnoPersist.setAmbitos(ambitos);

            this.alumnoDao.save(alumnoPersist);
        } else {
            Optional<Alumno> alumnoOptional = alumnoDao.findById(alumnoDTO.getId());

            if (alumnoOptional.isPresent()) {
                Alumno alumnoActualizado = alumnoMapper.alumnoDTOToAlumno(alumnoDTO);
                Alumno alumnoBBDD = alumnoOptional.get();

                // Preservar datos que no deben cambiar
                Persona personaBBDD = alumnoBBDD.getPersona();
                personaBBDD.setFechaAlta(alumnoBBDD.getPersona().getFechaAlta());
                personaBBDD.setRoles(alumnoBBDD.getPersona().getRoles());

                // Actualizar el resto usando el alumno mapeado
                alumnoBBDD.setNumeroExpediente(alumnoActualizado.getNumeroExpediente());
                alumnoBBDD.setNacionalidad(alumnoActualizado.getNacionalidad());
                alumnoBBDD.setNecesidadesEspeciales(alumnoActualizado.getNecesidadesEspeciales());
                alumnoBBDD.setAsignaturas(alumnoActualizado.getAsignaturas());

                // Solo actualizar los datos modificables de la persona
                personaBBDD.setNombre(alumnoDTO.getPersona().getNombre());
                personaBBDD.setApellido1(alumnoDTO.getPersona().getApellido1());
                personaBBDD.setApellido2(alumnoDTO.getPersona().getApellido2());
                personaBBDD.setEmail(alumnoDTO.getPersona().getEmail());

                // Manejar idiomas
                if (alumnoDTO.getIdiomas() != null) {
                    Set<AlumnoIdioma> idiomasDTO = alumnoIdiomaMapper.alumnosIdiomasDTOToAlumnosIdiomas(alumnoDTO.getIdiomas());

                    // Limpiar idiomas existentes manteniendo la colección
                    alumnoBBDD.getIdiomas().clear();
                    alumnoBBDD.getIdiomas().addAll(idiomasDTO);

                    idiomasDTO.forEach(idioma -> idioma.getId().setAlumno(alumnoBBDD));

                }


                // Manejar ámbitos
                for (AlumnoAmbitoDTO ambitoDTO : alumnoDTO.getAmbitos()) {
                    AlumnoAmbito ambitoExistente = alumnoBBDD.getAmbitos().stream()
                            .filter(a -> a.getId().getAmbito().getId().equals(ambitoDTO.getAmbito().getIdAmbito()))
                            .findFirst()
                            .orElseThrow(() -> new IllegalStateException(
                                    "No se encontró el ámbito " + ambitoDTO.getAmbito().getNombreAmbito() +
                                            " para el alumno " + alumnoBBDD.getId()));

                    if (!ambitoExistente.getNivelAcademico().getId().equals(ambitoDTO.getNivelAcademico().getIdNivelAcademico())) {
                        ambitoExistente.setNivelAcademico(this.nivelAcademicoDao.getReferenceById(
                                ambitoDTO.getNivelAcademico().getIdNivelAcademico()));
                    }
                }

                alumnoDao.save(alumnoBBDD);
            }
        }
    }

    private void comprobarNacionalidad(AlumnoDTO alumnoDTO) {
        if (Boolean.TRUE.equals(alumnoDTO.getExtranjero()) && alumnoDTO.getNacionalidad().isEmpty()) {
            alumnoDTO.setExtranjero(false);
        }
    }

    private void comprobarIdiomas(AlumnoDTO alumnoDTO) {

        if (alumnoDTO.getIdiomas() != null) {
            // Verificar si hay idiomas duplicados
            Set<String> idiomasUnicos = new HashSet<>();
            List<String> idiomasDuplicados = new ArrayList<>();
            for (AlumnoIdiomaDTO idiomaDTO : alumnoDTO.getIdiomas()) {
                String nombre = idiomaDTO.getIdioma().getNombreIdioma();
                if (!idiomasUnicos.add(nombre)) {
                    idiomasDuplicados.add(nombre);
                }
            }

            if (!idiomasDuplicados.isEmpty()) {
                throw new IllegalArgumentException(
                        "No se puede añadir el mismo idioma más de una vez: " +
                                String.join(", ", idiomasDuplicados)
                );
            }
        }
    }

    @Override
    public void deleteById(Integer id) {

        Alumno alumno = alumnoDao.findById(id).orElseThrow(() -> new IllegalArgumentException("No se encontró el alumno con id " + id));

        alumno.getPersona().setFechaBaja(LocalDate.now());
        alumnoDao.save(alumno);
    }
}
