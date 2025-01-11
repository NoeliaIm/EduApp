package com.niglesiasm.eduapp.repository.alumno.impl;

import com.niglesiasm.eduapp.model.Alumno;
import com.niglesiasm.eduapp.repository.alumno.AlumnoDao;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Alumno> findByIdPersona(Integer id) {
        String jpql = """
                    SELECT a
                    FROM Alumno a
                    JOIN FETCH a.persona p
                    WHERE p.id = :id
                """;

        return entityManager.createQuery(jpql, Alumno.class)
                .setParameter("id", id)
                .getResultStream()
                .findFirst();
    }
}
