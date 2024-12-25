package com.niglesiasm.eduapp.repository.profesor.impl;

import com.niglesiasm.eduapp.model.Profesor;
import com.niglesiasm.eduapp.repository.profesor.ProfesorDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfesorDaoHibernate extends SimpleJpaRepository<Profesor, Integer> implements ProfesorDao {

    private final EntityManager entityManager;

    @Autowired
    public ProfesorDaoHibernate(EntityManager entityManager) {
        super(Profesor.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public void flush() {
        super.flush();
    }

    @Override
    public List<Object[]> obtenerProfesoresByAnnioActual() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root<Profesor> profesorRoot = criteriaQuery.from(Profesor.class);

        Join<Object, Object> personaJoin = profesorRoot.join("persona");
        Join<Object, Object> asignaturaJoin = profesorRoot.join("asignaturas");
        Join<Object, Object> cursoJoin = asignaturaJoin.join("idCurso");
        Join<Object, Object> annioJoin = cursoJoin.join("idAnio");
        Join<Object, Object> nombreCursoJoin = cursoJoin.join("idNombre");

        criteriaQuery.multiselect(
                profesorRoot.get("id"),                       // ID del profesor
                personaJoin.get("id"),                       // ID de la persona
                personaJoin.get("nombre"),                   // Nombre de la persona
                personaJoin.get("apellido1"),                // Primer apellido
                personaJoin.get("apellido2"),                // Segundo apellido
                asignaturaJoin.get("id"),                    // ID de la asignatura
                asignaturaJoin.get("nombreAsignatura"),      // Nombre de la asignatura
                cursoJoin.get("id"),                         // ID del curso
                nombreCursoJoin.get("nombre"),               // Nombre del curso
                asignaturaJoin.get("descripcion"),           // Descripción de la asignatura
                asignaturaJoin.get("acron")                  // Acrónimo de la asignatura
        );

        // Agregar un filtro: Año académico activo
        criteriaQuery.where(criteriaBuilder.isTrue(annioJoin.get("activo")));

        return entityManager.createQuery(criteriaQuery).getResultList();

    }

}
