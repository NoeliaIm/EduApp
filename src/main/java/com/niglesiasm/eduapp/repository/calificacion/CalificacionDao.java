package com.niglesiasm.eduapp.repository.calificacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.niglesiasm.eduapp.model.Calificacion;

@Repository
public interface CalificacionDao extends JpaRepository<Calificacion, Long> {
    
}
