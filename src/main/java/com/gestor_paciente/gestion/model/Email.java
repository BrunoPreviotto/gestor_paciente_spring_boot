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
@Table(name = "emails")
public class Email {

    @Id
    @Column(name = "id_email")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String email;
}
