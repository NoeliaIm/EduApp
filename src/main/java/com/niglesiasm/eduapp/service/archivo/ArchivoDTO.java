package com.niglesiasm.eduapp.service.archivo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ArchivoDTO {

    private Long idArchivo;
    private String nombreArchivo;
    private String asignatura;
    private LocalDate fechaSubida;
    private String tamanio;
}
