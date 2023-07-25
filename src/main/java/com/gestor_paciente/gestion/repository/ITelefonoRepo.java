package com.gestor_paciente.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestor_paciente.gestion.model.Telefono;


public interface ITelefonoRepo extends JpaRepository<Telefono, Long>{
    
}
