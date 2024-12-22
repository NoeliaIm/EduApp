package com.niglesiasm.eduapp.service.necesidadEspecial;

import com.niglesiasm.eduapp.model.NecesidadEspecial;

import java.util.List;
import java.util.Set;

public interface NecesidadEspecialMapper {

    NecesidadEspecialDTO necesidadEspecialToNecesidadEspecialDTO(NecesidadEspecial necesidadEspecial);

    List<NecesidadEspecialDTO> necesidadesEspecialesToNecesidadesEspecialesDTO(Set<NecesidadEspecial> necesidadesEspeciales);
}
