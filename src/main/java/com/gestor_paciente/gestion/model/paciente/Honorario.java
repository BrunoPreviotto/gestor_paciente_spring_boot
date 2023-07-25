package com.gestor_paciente.gestion.model.paciente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "honorarios")
public class Honorario {

    @Id
    @Column(name = "id_honorario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "honorario")
    private Double honorario;
}
