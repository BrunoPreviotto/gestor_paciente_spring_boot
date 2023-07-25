package com.gestor_paciente.gestion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class Web {
    
    @Id
    @Column(name = "id_web")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String web;
    
}
