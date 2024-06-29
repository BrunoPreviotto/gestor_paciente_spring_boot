package com.gestor_paciente.gestion.service;

import java.util.List;



public interface CRUD<T> {
    public List<T> listarTodos();
    public T buscarPorId(Long id);
    public Long buscarIdPorDosCampos(String campo_uno, String campo_dos);
    public Long buscarIdPorUnCampo(String campo_uno);
    public void guardar(T objeto);
    public void actualizar(T objeto);
    public void eliminar(Long id);
    public void eliminarParcial(Long id);
    public boolean existeCampo(String campo);
}
