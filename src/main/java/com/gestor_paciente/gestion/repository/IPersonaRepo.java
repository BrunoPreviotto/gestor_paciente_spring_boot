package com.gestor_paciente.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestor_paciente.gestion.model.Persona;

import jakarta.transaction.Transactional;

public interface IPersonaRepo extends JpaRepository<Persona, Long>{
    
    @Modifying
    @Transactional
    @Query("UPDATE Persona p SET p.activo = false WHERE p.id = :id")
    void desactivateById(@Param("id")Long id);
}
