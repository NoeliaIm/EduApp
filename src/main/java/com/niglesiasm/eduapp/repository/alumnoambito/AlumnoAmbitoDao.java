package com.niglesiasm.eduapp.repository.alumnoambito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.niglesiasm.eduapp.model.AlumnoAmbito;

@Repository
public interface AlumnoAmbitoDao extends JpaRepository<AlumnoAmbito, Long> {
    
}
