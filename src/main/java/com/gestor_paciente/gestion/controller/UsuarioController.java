package com.gestor_paciente.gestion.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestor_paciente.gestion.model.usuario.Rol;
import com.gestor_paciente.gestion.model.usuario.Usuario;
import com.gestor_paciente.gestion.repository.usuario.IUsuarioRepo;
import com.gestor_paciente.gestion.service.UsuarioServiceImplement;
import com.gestor_paciente.gestion.util.RolNombre;


@RestController

public class UsuarioController {
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioServiceImplement usuarioService;

    @GetMapping("/usuario")
    public String bus(){
        return "home";
    }

    @PostMapping("/crearUsuario")
    public ResponseEntity<?> crearUsuario(@Validated @RequestBody Usuario usuarioParametro){
        
        Usuario usuario = Usuario.builder()
            .usuario(usuarioParametro.getUsuario())
            .contraseña(passwordEncoder.encode(usuarioParametro.getContraseña()))
            .email(usuarioParametro.getEmail())
            .build();

        
        
        usuarioService.guardar(usuario);

        return ResponseEntity.ok(usuario);
        
    }

    @DeleteMapping("/eliminarUsuario")
    public String eliminarUsuario(@RequestParam String id){
        usuarioService.eliminar(Integer.parseInt(id));
        return "/";
    }
}
