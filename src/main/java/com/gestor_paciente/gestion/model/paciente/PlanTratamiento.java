package com.gestor_paciente.gestion.model.paciente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "planes_tratamientos")
public class PlanTratamiento {
    
    @Id
    @Column(name = "id_plan_tratamiento")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String estrategia;

    @ManyToOne
    @JoinColumn(name = "id_frecuencia_sesion", referencedColumnName = "id_frecuencia_sesion")
    private FrecuenciaSesion frecuenciaSesion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_sesion", referencedColumnName = "id_tipo_sesion")
    private TipoSesion tipoSEsion;
    
}
