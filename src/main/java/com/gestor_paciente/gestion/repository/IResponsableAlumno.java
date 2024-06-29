package com.gestor_paciente.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestor_paciente.gestion.model.ResponsableAlumno;

public interface IResponsableAlumno extends JpaRepository<ResponsableAlumno, Long> {
    
}
