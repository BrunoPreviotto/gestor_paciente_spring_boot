package com.gestor_paciente.gestion.service;

import java.util.List;

import com.gestor_paciente.gestion.model.paciente.Honorario;

public interface CRUD<T> {
    public List<T> listarTodos();
    public T buscarPorId(Long id);
    public void guardar(T objeto);
    public void actualizar(T objeto);
    public void eliminar(Long id);
}
