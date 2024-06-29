package com.gestor_paciente.gestion.mapper;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.gestor_paciente.gestion.dto.ColaboradorDTO;
import com.gestor_paciente.gestion.model.Colaborador;

@Component
public class ColaboradorMapper implements IMapper<ColaboradorDTO, Colaborador>{

   
    CursoMapper cursoMapper;

    @Autowired
    public ColaboradorMapper(@Lazy CursoMapper cursoMapper) {
        this.cursoMapper = cursoMapper;
    }


    @Override
    public ColaboradorDTO aDTO(Colaborador colaborador) {
         if (colaborador == null) {
            return null;
        }
        ColaboradorDTO dto = new ColaboradorDTO();
        dto.setId(colaborador.getId());
        dto.setNombre(colaborador.getNombre());
        dto.setDescripcion(colaborador.getDescripcion());
        dto.setEdad(colaborador.getEdad());
        dto.setActivo(colaborador.isActivo());
        dto.setTelefono(colaborador.getTelefono());
        dto.setCursos(colaborador.getCursos().stream().map(cursoMapper::aDTO).collect(Collectors.toList()));
        // Mapear otros campos según sea necesario
        return dto;
    }

    @Override
    public Colaborador aEntity(ColaboradorDTO dto) {
        if (dto == null) {
            return null;
        }
        Colaborador colaborador = new Colaborador();
        colaborador.setId(dto.getId());
        dto.setNombre(dto.getNombre());
        colaborador.setDescripcion(dto.getDescripcion());
        colaborador.setEdad(dto.getEdad());
        //colaborador.setCursos(dto.getCursos().stream().map(cursoMapper::aEntity).collect(Collectors.toList()));

        return colaborador;
    }
    
}
