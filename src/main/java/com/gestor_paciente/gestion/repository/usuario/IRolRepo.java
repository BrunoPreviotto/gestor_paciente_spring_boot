package com.gestor_paciente.gestion.repository.usuario;

import org.springframework.data.repository.CrudRepository;

import com.gestor_paciente.gestion.model.usuario.Rol;

public interface IRolRepo extends CrudRepository<Rol, Integer>{
    
}
