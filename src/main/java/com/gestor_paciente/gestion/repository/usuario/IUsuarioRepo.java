package com.gestor_paciente.gestion.repository.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gestor_paciente.gestion.model.usuario.Usuario;


public interface IUsuarioRepo extends CrudRepository<Usuario, Integer>{
   @Query("select u from Usuario u where u.usuario = ?1")
    Optional<Usuario> findByUsuername(String username);

    Optional<Usuario> findOneByEmail(String email);


}
