package com.niglesiasm.eduapp.repository.alumno;

import com.niglesiasm.eduapp.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlumnoDao extends JpaRepository<Alumno, Integer> {

    //Optional<Alumno> findByIdPersona(Integer id);
}
