package com.niglesiasm.eduapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class AlumnoAsignaturaId implements java.io.Serializable {
    private static final long serialVersionUID = -7998978734276779376L;
    @NotNull
    @Column(name = "id_alumno", nullable = false)
    private Integer id_alumno;

    @NotNull
    @Column(name = "id_asignatura", nullable = false)
    private Integer id_asignatura;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AlumnoAsignaturaId entity = (AlumnoAsignaturaId) o;
        return Objects.equals(this.id_asignatura, entity.id_asignatura) &&
                Objects.equals(this.id_alumno, entity.id_alumno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_asignatura, id_alumno);
    }

}