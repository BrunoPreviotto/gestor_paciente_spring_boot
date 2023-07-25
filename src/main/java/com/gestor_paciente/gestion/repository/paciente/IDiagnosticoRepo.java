package com.gestor_paciente.gestion.repository.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestor_paciente.gestion.model.paciente.Diagnostico;

public interface IDiagnosticoRepo extends JpaRepository<Diagnostico, Long>{
    
}
