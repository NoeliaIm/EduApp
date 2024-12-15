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
public class AlumnoIdiomaId implements java.io.Serializable {
    private static final long serialVersionUID = 2640200938380785296L;
    @NotNull
    @Column(name = "id_alumno", nullable = false)
    private Integer id_alumno;

    @NotNull
    @Column(name = "id_idioma", nullable = false)
    private Integer id_idioma;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AlumnoIdiomaId entity = (AlumnoIdiomaId) o;
        return Objects.equals(this.id_alumno, entity.id_alumno) &&
                Objects.equals(this.id_idioma, entity.id_idioma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_alumno, id_idioma);
    }

}