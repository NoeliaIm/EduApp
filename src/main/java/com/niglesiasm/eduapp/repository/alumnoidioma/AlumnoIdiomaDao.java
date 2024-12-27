package com.niglesiasm.eduapp.repository.alumnoidioma;

import com.niglesiasm.eduapp.model.AlumnoIdioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoIdiomaDao extends JpaRepository<AlumnoIdioma, Integer> {

}
