package com.gestor_paciente.gestion.dto;

import com.gestor_paciente.gestion.model.Nombre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamiliarDTO {
    private Long id;
    private Nombre nombre;
    private int edad;
    private String descripcion;
    
}
