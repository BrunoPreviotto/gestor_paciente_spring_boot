package com.gestor_paciente.gestion.service;

import java.util.List;

import com.gestor_paciente.gestion.model.usuario.Usuario;

public interface IUsuarioService {
    public List<Usuario> listarTodos();
    public Usuario buscarPorId(int id);
    public void guardar(Usuario usuario);
    public void actualizar(Usuario usuario);
    public void eliminar(int id);
}
