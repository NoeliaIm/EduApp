package com.niglesiasm.eduapp.repository.alumnoasignatura;

import com.niglesiasm.eduapp.model.AlumnoAsignatura;
import com.niglesiasm.eduapp.model.AlumnoAsignaturaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoAsignaturaDao extends JpaRepository<AlumnoAsignatura, AlumnoAsignaturaId> {

    @Query("SELECT aa FROM AlumnoAsignatura aa WHERE aa.id.id_alumno = :idAlumno AND aa.id.id_asignatura = :idAsignatura")
    AlumnoAsignatura findByAlumnoIdAndAsignaturaId(@Param("idAlumno") Integer idAlumno, @Param("idAsignatura") Integer idAsignatura);
}
