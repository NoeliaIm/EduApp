package com.niglesiasm.eduapp.repository.ambitoacademico;

import com.niglesiasm.eduapp.model.AmbitoAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbitoAcademicoDao extends JpaRepository<AmbitoAcademico, Integer> {
}
