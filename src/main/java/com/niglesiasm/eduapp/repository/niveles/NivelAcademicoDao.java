package com.niglesiasm.eduapp.repository.niveles;


import com.niglesiasm.eduapp.model.NivelAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelAcademicoDao extends JpaRepository<NivelAcademico, Integer> {
}
