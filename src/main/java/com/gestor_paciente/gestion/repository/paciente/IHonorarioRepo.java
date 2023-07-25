package com.gestor_paciente.gestion.repository.paciente;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestor_paciente.gestion.model.paciente.Honorario;


public interface IHonorarioRepo extends JpaRepository<Honorario, Long>{
    
}
