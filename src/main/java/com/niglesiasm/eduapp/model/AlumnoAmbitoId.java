package com.niglesiasm.eduapp.model;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AlumnoAmbitoId implements Serializable {
    private Integer idAlumno;
    private Integer idAmbito;
}