package com.niglesiasm.eduapp.service.alumnoidioma;

import com.niglesiasm.eduapp.model.AlumnoIdioma;
import com.niglesiasm.eduapp.repository.alumnoidioma.AlumnoIdiomaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoIdiomaService {

    private final AlumnoIdiomaDao repository;

    @Autowired
    public AlumnoIdiomaService(AlumnoIdiomaDao repository) {
        this.repository = repository;
    }

    public List<AlumnoIdioma> findAll() {
        return repository.findAll();
    }

    public Optional<AlumnoIdioma> findById(Integer id) {
        return repository.findById(id);
    }

    public AlumnoIdioma save(AlumnoIdioma entity) {
        return repository.save(entity);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
