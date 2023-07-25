package com.gestor_paciente.gestion.model.obra_social;



import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;



@Entity
@Data
@Table(name = "planes_obra_social")
public class PlanObraSocial {
    @Id
    @Column(name = "id_plan_obra_social")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String plan;

    @ManyToMany
    @JoinTable(name = "obras_sociales", joinColumns = @JoinColumn(name = "id_plan_obra_social"), inverseJoinColumns = @JoinColumn(name = "id_obra_social"))
    private List<ObraSocial> obraSocial;
}
