package com.niglesiasm.eduapp.service.profesor.impl;

import com.niglesiasm.eduapp.model.Persona;
import com.niglesiasm.eduapp.model.Profesor;
import com.niglesiasm.eduapp.model.enums.Rol;
import com.niglesiasm.eduapp.repository.profesor.ProfesorDao;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaMapper;
import com.niglesiasm.eduapp.service.profesor.ProfesorDTO;
import com.niglesiasm.eduapp.service.profesor.ProfesorMapper;
import com.niglesiasm.eduapp.service.profesor.ProfesorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorDao profesorDao;

    private final ProfesorMapper profesorMapper;

    private final AsignaturaMapper asignaturaMapper;


    @Autowired
    public ProfesorServiceImpl(ProfesorDao profesorDao, ProfesorMapper profesorMapper, AsignaturaMapper asignaturaMapper) {
        this.profesorDao = profesorDao;
        this.profesorMapper = profesorMapper;
        this.asignaturaMapper = asignaturaMapper;
    }

    @Override
    public List<ProfesorDTO> obtenerProfesoresByAnnioActual() {
        List<Object[]> profesorList = profesorDao.obtenerProfesoresByAnnioActual();
        return this.profesorMapper.profesoresToProfesoresDTO(profesorList);
    }

    @Override
    @Transactional
    public void guardarOActualizarProfesor(ProfesorDTO profesorDTO) {
        // encontrar profesor por email
        Profesor profesor = this.findByEmail(profesorDTO.getPersona().getEmail());
        if (profesor != null) {
            // actualizar profesor
            profesor.getPersona().setNombre(profesorDTO.getPersona().getNombre());
            profesor.getPersona().setApellido1(profesorDTO.getPersona().getApellido1());
            profesor.getPersona().setApellido2(profesorDTO.getPersona().getApellido2());
            profesor.getPersona().setEmail(profesorDTO.getPersona().getEmail());
            profesor.setAsignaturas(this.asignaturaMapper.asignaturasDTOToAsignaturas(profesorDTO.getAsignaturas()));
            this.profesorDao.guardarProfesor(profesor);
        } else {

            Persona persona = new Persona();
            persona.setNombre(profesorDTO.getPersona().getNombre());
            persona.setApellido1(profesorDTO.getPersona().getApellido1());
            persona.setApellido2(profesorDTO.getPersona().getApellido2());
            persona.setEmail(profesorDTO.getPersona().getEmail());
            persona.setFechaAlta(LocalDate.now());
            persona.setRoles(Set.of(Rol.PROF));
            Profesor newProfesor = new Profesor();
            newProfesor.setPersona(persona);
            newProfesor.setAsignaturas(this.asignaturaMapper.asignaturasDTOToAsignaturas(profesorDTO.getAsignaturas()));
            this.profesorDao.guardarProfesor(newProfesor);
        }
    }

    @Override
    public void deleteById(Integer id) {

    }

    private Profesor findByEmail(String email) {
        return profesorDao.findProfesorByEmail(email);
    }
}
