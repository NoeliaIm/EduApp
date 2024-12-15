package com.niglesiasm.eduapp.repository.alumnoambito;

import com.niglesiasm.eduapp.model.AlumnoAmbito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoAmbitoDao extends JpaRepository<AlumnoAmbito, Long> {

}
