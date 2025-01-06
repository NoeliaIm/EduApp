package com.niglesiasm.eduapp.service.archivo.impl;

import com.niglesiasm.eduapp.model.Archivo;
import com.niglesiasm.eduapp.model.Asignatura;
import com.niglesiasm.eduapp.repository.archivo.ArchivoDao;
import com.niglesiasm.eduapp.repository.asignatura.AsignaturaDao;
import com.niglesiasm.eduapp.service.archivo.ArchivoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArchivoServiceImpl implements ArchivoService {


    private final AsignaturaDao asignaturaDao;
    private final ArchivoDao archivoDao;


    public ArchivoServiceImpl(AsignaturaDao asignaturaDao, ArchivoDao archivoDao) {
        this.asignaturaDao = asignaturaDao;
        this.archivoDao = archivoDao;
    }

    @Override
    @Transactional
    public void guardarDatosArchivo(MultipartFile file, String subjectId) {
        Archivo archivo = this.createArchivo(file, subjectId);
        this.archivoDao.save(archivo);
    }


    private Archivo createArchivo(MultipartFile file, String subjectId) {
        Asignatura asignatura = asignaturaDao.findByIdAsignatura(Integer.parseInt(subjectId));

        Archivo archivo = new Archivo();
        archivo.setFileName(file.getOriginalFilename()); // file.getName() no da el nombre real del archivo
        archivo.setIdAsignatura(asignatura);
        archivo.setFileSize(file.getSize());
        

        return archivo;
    }
}
