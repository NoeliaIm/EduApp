package com.niglesiasm.eduapp.repository.calificacion;

import com.niglesiasm.eduapp.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionDao extends JpaRepository<Calificacion, Integer> {

    List<Calificacion> findByAlumnoId(Integer idAlumno);
}
