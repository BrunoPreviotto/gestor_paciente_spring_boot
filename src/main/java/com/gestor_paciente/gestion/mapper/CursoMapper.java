package com.gestor_paciente.gestion.mapper;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.gestor_paciente.gestion.dto.CursoDTO;
import com.gestor_paciente.gestion.mapper.IMapper;
import com.gestor_paciente.gestion.model.Curso;

@Component
public class CursoMapper implements IMapper<CursoDTO, Curso>{
    
    
    ColaboradorMapper colaboradorMapper;

    @Autowired
    public CursoMapper(@Lazy ColaboradorMapper colaboradorMapper) {
        this.colaboradorMapper = colaboradorMapper;
    }

    
    @Override
    public CursoDTO aDTO(Curso curso) {
        if (curso == null) {
            return null;
        }
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        dto.setDescripcion(curso.getDescripcion());
        dto.setColaborador(curso.getColaboradores().stream().map(colaboradorMapper::aDTO).collect(Collectors.toList()));
        // Mapear otros campos según sea necesario
        return dto;
    }

    @Override
    public Curso aEntity(CursoDTO dto) {
        if (dto == null) {
            return null;
        }
        Curso Curso = new Curso();
        Curso.setId(dto.getId());
        Curso.setNombre(dto.getNombre());
        Curso.setDescripcion(dto.getDescripcion());
        
        Curso.setColaboradores(dto.getColaborador().stream().map(colaboradorMapper::aEntity).collect(Collectors.toList()));
        // Mapear otros campos según sea necesario
        return Curso;
    }
}
