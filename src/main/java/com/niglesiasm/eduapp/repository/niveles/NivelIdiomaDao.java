package com.niglesiasm.eduapp.repository.niveles;


import com.niglesiasm.eduapp.model.NivelIdioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NivelIdiomaDao extends JpaRepository<NivelIdioma, Integer> {
}
