package com.niglesiasm.eduapp.repository.calificacion;

import com.niglesiasm.eduapp.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificacionDao extends JpaRepository<Calificacion, Long> {

}
