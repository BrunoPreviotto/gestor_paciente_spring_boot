package com.gestor_paciente.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestor_paciente.gestion.model.Nombre;
import com.gestor_paciente.gestion.repository.INombreRepo;

@Service
@Qualifier("nombre_service")
public class NombreServiceImplement implements CRUD<Nombre>{

    @Autowired
    private INombreRepo repo;

    @Override
    public List<Nombre> listarTodos() {
        return (List<Nombre>) repo.findAll();
    }

    @Override
    public Nombre buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void guardar(Nombre nombre) {
        repo.save(nombre);
    }

    @Override
    public void actualizar(Nombre nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
    
}
