package com.niglesiasm.eduapp.repository.asignatura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.niglesiasm.eduapp.model.Asignatura;

@Repository
public interface AsignaturaDao extends JpaRepository<Asignatura, Long> {
    
}
