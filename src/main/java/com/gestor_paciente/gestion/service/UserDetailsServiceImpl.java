package com.gestor_paciente.gestion.service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gestor_paciente.gestion.model.usuario.Usuario;
import com.gestor_paciente.gestion.repository.usuario.IUsuarioRepo;
import com.gestor_paciente.gestion.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private IUsuarioRepo repo;

    

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        Usuario usuarios = repo.findOneByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("El usuario " + email + " no existe"));


        /*return new User(usuarios.getUsuario(), 
                        usuarios.getContraseña(), 
                        true, 
                        true, 
                        true, 
                        true, 
                        null);*/
        return new UserDetailsImpl(usuarios);
    }
    
}
