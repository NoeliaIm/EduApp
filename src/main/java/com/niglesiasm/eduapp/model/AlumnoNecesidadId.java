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
public class AlumnoNecesidadId implements java.io.Serializable {
    private static final long serialVersionUID = 1125738741933608301L;
    @NotNull
    @Column(name = "id_alumno", nullable = false)
    private Integer id_alumno;

    @NotNull
    @Column(name = "id_necesidad", nullable = false)
    private Integer id_necesidad;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AlumnoNecesidadId entity = (AlumnoNecesidadId) o;
        return Objects.equals(this.id_alumno, entity.id_alumno) &&
                Objects.equals(this.id_necesidad, entity.id_necesidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_alumno, id_necesidad);
    }

}