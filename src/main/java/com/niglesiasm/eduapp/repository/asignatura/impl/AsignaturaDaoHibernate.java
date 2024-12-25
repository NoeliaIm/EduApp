package com.niglesiasm.eduapp.repository.asignatura.impl;

import com.niglesiasm.eduapp.model.Asignatura;
import com.niglesiasm.eduapp.repository.asignatura.AsignaturaDao;
import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;
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
public class AsignaturaDaoHibernate extends SimpleJpaRepository<Asignatura, Integer> implements AsignaturaDao {


    private final EntityManager entityManager;

    @Autowired
    public AsignaturaDaoHibernate(EntityManager entityManager) {
        super(Asignatura.class, entityManager);
        this.entityManager = entityManager;
    }


    @Override
    public void flush() {
        super.flush();
    }


    @Override
    public List<AsignaturaDTO> obtenerAsignaturasByAnnioActual() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AsignaturaDTO> criteriaQuery = criteriaBuilder.createQuery(AsignaturaDTO.class);
        Root<Asignatura> asignaturaRoot = criteriaQuery.from(Asignatura.class);

        Join<Object, Object> cursoJoin = asignaturaRoot.join("idCurso");
        Join<Object, Object> annioJoin = cursoJoin.join("idAnio");
        Join<Object, Object> nombreCursoJoin = cursoJoin.join("idNombre");


        criteriaQuery.select(criteriaBuilder.construct(
                AsignaturaDTO.class,
                asignaturaRoot.get("id"),
                asignaturaRoot.get("nombreAsignatura"),
                cursoJoin.get("id"),
                nombreCursoJoin.get("nombre"),
                asignaturaRoot.get("descripcion"),
                asignaturaRoot.get("acron")
        )).where(criteriaBuilder.isTrue(annioJoin.get("activo")));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
