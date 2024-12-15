package com.niglesiasm.eduapp.repository.idioma;

import com.niglesiasm.eduapp.model.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdiomaDao extends JpaRepository<Idioma, Long> {

}
