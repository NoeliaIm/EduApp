package com.niglesiasm.eduapp.repository.alumno.impl;

import com.niglesiasm.eduapp.model.Alumno;
import com.niglesiasm.eduapp.repository.alumno.AlumnoDao;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlumnoDaoHibernate extends SimpleJpaRepository<Alumno, Integer> implements AlumnoDao {

    private final EntityManager entityManager;

    @Autowired
    public AlumnoDaoHibernate(EntityManager entityManager) {
        super(Alumno.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public List<Alumno> getAlumnosAnnioEncurso() {

        String jpql = """
                    SELECT a
                    FROM Alumno a
                    LEFT JOIN FETCH a.asignaturas asignatura
                    JOIN asignatura.curso curso
                    JOIN curso.idAnio anioAcademico
                    WHERE anioAcademico.activo = true
                """;


        return entityManager.createQuery(jpql, Alumno.class).getResultList();
    }

    @Override
    public Alumno save(Alumno alumnoPersist) {
        super.save(alumnoPersist);
        entityManager.flush();
        return alumnoPersist;
    }
}
