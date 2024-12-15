package com.niglesiasm.eduapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "profesor_asignatura", schema = "eduapp")
public class ProfesorAsignatura {
    @EmbeddedId
    private ProfesorAsignaturaId id;

    @MapsId("id_asignatura")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_asignatura", nullable = false)
    private Asignatura idAsignatura;

}