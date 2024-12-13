package com.niglesiasm.eduapp.repository.idioma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.niglesiasm.eduapp.model.Idioma;

@Repository
public interface IdiomaDao extends JpaRepository<Idioma, Long> {
    
}
