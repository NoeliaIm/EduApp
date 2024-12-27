package com.niglesiasm.eduapp.repository.nacionalidad;

import com.niglesiasm.eduapp.model.Nacionalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NacionalidadDao extends JpaRepository<Nacionalidad, Integer> {

    Optional<Nacionalidad> findByNombre(String nombre);

}
