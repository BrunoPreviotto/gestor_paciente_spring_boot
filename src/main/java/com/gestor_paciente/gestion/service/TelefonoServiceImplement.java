package com.gestor_paciente.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestor_paciente.gestion.model.Telefono;
import com.gestor_paciente.gestion.repository.ITelefonoRepo;

@Service
@Qualifier("telefono_service")
public class TelefonoServiceImplement implements CRUD<Telefono>{

    @Autowired
    private ITelefonoRepo repo;

    @Override
    public List<Telefono> listarTodos() {
        return (List<Telefono>) repo.findAll();
    }

    @Override
    public Telefono buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void guardar(Telefono telefono) {
        repo.save(telefono);
    }

    @Override
    public void actualizar(Telefono telefono) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    @Override
    public boolean existeCampo(String campo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existeCampo'");
    }

    @Override
    public Long buscarIdPorDosCampos(String campo_uno, String campo_dos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarIdPorDosCampos'");
    }

    @Override
    public Long buscarIdPorUnCampo(String campo_uno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarIdPorUnCampo'");
    }

    @Override
    public void eliminarParcial(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarParcial'");
    }
    
}
