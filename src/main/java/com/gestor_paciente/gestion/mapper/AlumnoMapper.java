package com.gestor_paciente.gestion.mapper;

import java.util.stream.Collectors;

import com.gestor_paciente.gestion.dto.AlumnoDTO;
import com.gestor_paciente.gestion.dto.FamiliarDTO;
import com.gestor_paciente.gestion.model.Alumno;
import com.gestor_paciente.gestion.model.Familiar;

import lombok.Data;


public class AlumnoMapper implements IMapper<AlumnoDTO, Alumno>{
    
    private FamiliarMapper familiarMapper = new FamiliarMapper();


    @Override
    public AlumnoDTO aDTO(Alumno alumno) {
        if (alumno == null) {
            return null;
        }
        AlumnoDTO dto = new AlumnoDTO();
        dto.setId(alumno.getId());
        dto.setNombre(alumno.getNombre());
        dto.setDescripcion(alumno.getDescripcion());
        dto.setEdad(alumno.getEdad());
        dto.setActivo(alumno.isActivo());
        dto.setFamiliares(alumno.getFamiliares().stream().map(familiarMapper::aDTO).collect(Collectors.toList()));
        // Mapear otros campos según sea necesario
        return dto;
    }

    @Override
    public Alumno aEntity(AlumnoDTO dto) {
        if (dto == null) {
            return null;
        }
        Alumno alumno = new Alumno();
        alumno.setId(dto.getId());
        alumno.setNombre(dto.getNombre());
        alumno.setDescripcion(dto.getDescripcion());
        alumno.setEdad(dto.getEdad());
        alumno.setActivo(dto.isActivo());
        alumno.setFamiliares(dto.getFamiliares().stream().map(familiarMapper::aEntity).collect(Collectors.toList()));
        // Mapear otros campos según sea necesario
        return alumno;
    }

   
}
