package com.gestor_paciente.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestor_paciente.gestion.model.usuario.Usuario;
import com.gestor_paciente.gestion.repository.usuario.IUsuarioRepo;

@Service
public class UsuarioServiceImplement implements IUsuarioService{
    
    @Autowired
    private IUsuarioRepo repo;
   // @Autowired
    //private PasswordEncoder passwordEncoder;

    

    @Override
    public List<Usuario> listarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

    @Override
    public Usuario buscarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public void guardar(Usuario usuario) {
       // String encodedPassword = passwordEncoder.encode(usuario.getContraseña());
        //usuario.setContraseña(encodedPassword);
        repo.save(usuario);
    }

    @Override
    public void actualizar(Usuario usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }
    
}
