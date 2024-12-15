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
public class PersonaRolId implements java.io.Serializable {
    private static final long serialVersionUID = 9171616138573203670L;
    @NotNull
    @Column(name = "id_persona", nullable = false)
    private Integer id_persona;

    @NotNull
    @Column(name = "id_role", nullable = false)
    private Integer id_role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonaRolId entity = (PersonaRolId) o;
        return Objects.equals(this.id_persona, entity.id_persona) &&
                Objects.equals(this.id_role, entity.id_role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_persona, id_role);
    }

}