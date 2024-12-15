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
public class AlumnoAmbitoId implements java.io.Serializable {
    private static final long serialVersionUID = -8402834939414940611L;
    @NotNull
    @Column(name = "id_alumno", nullable = false)
    private Integer id_alumno;

    @NotNull
    @Column(name = "id_ambito", nullable = false)
    private Integer id_ambito;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AlumnoAmbitoId entity = (AlumnoAmbitoId) o;
        return Objects.equals(this.id_ambito, entity.id_ambito) &&
                Objects.equals(this.id_alumno, entity.id_alumno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_ambito, id_alumno);
    }

}