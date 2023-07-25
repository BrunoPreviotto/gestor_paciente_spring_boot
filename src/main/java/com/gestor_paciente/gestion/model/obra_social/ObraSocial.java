package com.gestor_paciente.gestion.model.obra_social;

import java.util.List;

import com.gestor_paciente.gestion.model.Email;
import com.gestor_paciente.gestion.model.Telefono;
import com.gestor_paciente.gestion.model.Web;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "obras_sociales")
public class ObraSocial {
    
    @Id
    @Column(name = "id_obra_social")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String nombre;

    @OneToOne
    @JoinColumn(name = "id_telefono", referencedColumnName = "id_telefono")
    private Telefono telefono;

    @OneToOne
    @JoinColumn(name = "id_web", referencedColumnName = "id_web")
    private Web web;

    @OneToOne
    @JoinColumn(name = "id_email", referencedColumnName = "id_email")
    private Email email;
    
    
    //
    
    @ManyToMany
    @JoinTable(name = "planes_obra_social", joinColumns = @JoinColumn(name = "id_obra_social"), inverseJoinColumns = @JoinColumn(name = "id_plan_obra_social"))
    private List<PlanObraSocial> planes;
    
}
