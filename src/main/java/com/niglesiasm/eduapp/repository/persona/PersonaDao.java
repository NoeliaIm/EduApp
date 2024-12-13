package com.niglesiasm.eduapp.repository.persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.niglesiasm.eduapp.model.Persona;

import java.util.Optional;

@Repository
public interface PersonaDao extends JpaRepository<Persona, Long> {
    Optional<Persona> findByEmail(String email);
    boolean existsByEmail(String email);
    
}
