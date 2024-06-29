package com.gestor_paciente.gestion.model.paciente;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;



public class Sesion {

   /*  @Id
    @Column(name = "id_sesion")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private Integer numeroSesion;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column
    private LocalDate fecha;

    @Column
    private String trabajoSesion;

    @Column
    private String observacion;

    @Column
    private String motivoTrabajoEmergente;
    //private Autorizacion autorizacion;

    //@Column
    //private EstadoFacturacion estado;

    @Column
    private Double honorarioPorSesion;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    */
}
