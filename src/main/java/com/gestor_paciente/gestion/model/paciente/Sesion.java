package com.gestor_paciente.gestion.model.paciente;

import java.time.LocalDate;

public class Sesion {
    private int id;
    private Integer numeroSesion;
    private LocalDate fecha;
    private String trabajoSesion;
    private String observacion;
    private String motivoTrabajoEmergente;
    private Autorizacion autorizacion;
    private EstadoFacturacion estado;
    private Double honorarioPorSesion;
    
}
