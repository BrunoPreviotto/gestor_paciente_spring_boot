package com.gestor_paciente.gestion.dto;


import java.util.List;

import com.gestor_paciente.gestion.model.Colaborador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private List<ColaboradorDTO> colaborador;
}
