package com.gestor_paciente.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestor_paciente.gestion.model.GrupoFamiliar;

public interface IGrupoFamiliar extends JpaRepository<GrupoFamiliar, Long>{
    
}
