package com.gestor_paciente.gestion.model.paciente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "diagnosticos")
public class Diagnostico {
    
    @Id
    @Column(name = "id_diagnostico")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column
    private String diagnostico;

    @Column
    private String observacion;
    
}
