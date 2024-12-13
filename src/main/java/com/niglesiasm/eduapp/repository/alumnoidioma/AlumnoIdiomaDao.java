package com.niglesiasm.eduapp.repository.alumnoidioma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.niglesiasm.eduapp.model.AlumnoIdioma;

@Repository
public interface AlumnoIdiomaDao extends JpaRepository<AlumnoIdioma, Long> {
    
}
