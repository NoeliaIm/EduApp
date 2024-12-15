package com.niglesiasm.eduapp.repository.asignatura;

import com.niglesiasm.eduapp.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaDao extends JpaRepository<Asignatura, Long> {

}
