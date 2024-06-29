package com.gestor_paciente.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestor_paciente.gestion.model.Nombre;


public interface INombreRepo extends JpaRepository<Nombre, Long>{
    boolean existsByNombre(String nombre);

    @Query("SELECT p.id FROM Nombre p WHERE p.nombre = :nombre AND p.apellido = :apellido")
    Long findIdByNombreAndApellido(@Param("nombre")String nombre, @Param("apellido")String apellido);
}
