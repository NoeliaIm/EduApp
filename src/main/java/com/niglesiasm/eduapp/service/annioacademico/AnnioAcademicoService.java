package com.niglesiasm.eduapp.service.annioacademico;

import com.niglesiasm.eduapp.model.AnnioAcademico;
import com.niglesiasm.eduapp.repository.annioacademico.AnnioAcademicoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnioAcademicoService {

    private final AnnioAcademicoDao repository;

    @Autowired
    public AnnioAcademicoService(AnnioAcademicoDao repository) {
        this.repository = repository;
    }

    public List<AnnioAcademico> findAll() {
        return repository.findAll();
    }

    public Optional<AnnioAcademico> findById(Long id) {
        return repository.findById(id);
    }

    public AnnioAcademico save(AnnioAcademico entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
