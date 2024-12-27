package com.niglesiasm.eduapp.service.necesidadespecial;

import com.niglesiasm.eduapp.model.NecesidadEspecial;

import java.util.List;
import java.util.Set;

public interface NecesidadEspecialMapper {

    NecesidadEspecialDTO necesidadEspecialToNecesidadEspecialDTO(NecesidadEspecial necesidadEspecial);

    List<NecesidadEspecialDTO> necesidadesEspecialesToNecesidadesEspecialesDTO(Set<NecesidadEspecial> necesidadesEspeciales);

    NecesidadEspecial necesidadEspecialDTOToNecesidadEspecial(NecesidadEspecialDTO necesidadEspecialDTO);

    Set<NecesidadEspecial> necesidadesEspecialesDTOToNecesidadesEspeciales(List<NecesidadEspecialDTO> necesidadesEspecialesDTO);
}
