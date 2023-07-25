package com.gestor_paciente.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestor_paciente.gestion.model.Nombre;


public interface INombreRepo extends JpaRepository<Nombre, Long>{
    
}
