package com.gestor_paciente.gestion.repository.paciente;

import com.gestor_paciente.gestion.model.paciente.Sesion;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ISesionRepo extends JpaRepository<Sesion, Long> {
    
    
}
