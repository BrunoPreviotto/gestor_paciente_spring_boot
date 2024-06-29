package com.gestor_paciente.gestion.dto;

import java.util.List;

import com.gestor_paciente.gestion.model.Nombre;
import com.gestor_paciente.gestion.model.Telefono;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorDTO {
    private Long id;
    private Integer edad;
    private Nombre nombre;
    private String descripcion;
    private boolean activo;
    private List<CursoDTO> cursos;
    private Telefono telefono;


    
}
