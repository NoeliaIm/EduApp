package com.niglesiasm.eduapp.service.archivo;

import com.niglesiasm.eduapp.service.asignatura.AsignaturaDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ArchivoDTO {

    private Long idArchivo;
    private String nombreArchivo;
    private AsignaturaDTO asignatura;
    private LocalDate fechaSubida;
    private String tamanio;
}
