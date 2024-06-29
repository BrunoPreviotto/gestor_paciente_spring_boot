package com.gestor_paciente.gestion.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestor_paciente.gestion.model.Curso;


public interface ICursoRepo extends JpaRepository<Curso, Long>{
     
    @Query("SELECT c.id FROM Curso c WHERE c.nombre = :nombre")
    Long findIdByNombre(@Param("nombre")String nombre);
}
