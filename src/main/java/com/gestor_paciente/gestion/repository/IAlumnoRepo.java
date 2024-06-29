package com.gestor_paciente.gestion.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gestor_paciente.gestion.model.Alumno;

public interface IAlumnoRepo extends JpaRepository<Alumno, Long>{
   
}
