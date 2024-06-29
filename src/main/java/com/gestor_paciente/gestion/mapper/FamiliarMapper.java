package com.gestor_paciente.gestion.mapper;

import com.gestor_paciente.gestion.dto.FamiliarDTO;
import com.gestor_paciente.gestion.model.Familiar;

public class FamiliarMapper implements IMapper<FamiliarDTO, Familiar> {

    @Override
    public FamiliarDTO aDTO(Familiar familiar) {
        if (familiar == null) {
            return null;
        }
        FamiliarDTO dto = new FamiliarDTO();
        dto.setId(familiar.getId());
        dto.setNombre(familiar.getNombre());
        dto.setDescripcion(familiar.getDescripcion());
        dto.setEdad(familiar.getEdad());
        // Mapear otros campos según sea necesario
        return dto;
    }

    @Override
    public Familiar aEntity(FamiliarDTO dto) {
       if (dto == null) {
            return null;
        }
        Familiar familiar = new Familiar();
        familiar.setId(dto.getId());
        dto.setNombre(dto.getNombre());
        familiar.setDescripcion(dto.getDescripcion());
        familiar.setEdad(dto.getEdad());
        // Mapear otros campos según sea necesario
        return familiar;
    }
    
}
