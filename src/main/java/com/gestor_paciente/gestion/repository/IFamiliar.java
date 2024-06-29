package com.gestor_paciente.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestor_paciente.gestion.model.Familiar;

public interface IFamiliar extends JpaRepository<Familiar, Long>{
    
}
