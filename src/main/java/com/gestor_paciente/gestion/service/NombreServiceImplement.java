package com.gestor_paciente.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

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
        return repo.findById(id)
        .orElseThrow(() -> new ResourceAccessException("Nombre no encontrado"));
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

    @Override
    public boolean existeCampo(String campo) {
        return repo.existsByNombre(campo);
    }

    @Override
    public Long buscarIdPorDosCampos(String campo_uno, String campo_dos) {
        return repo.findIdByNombreAndApellido(campo_uno, campo_dos);
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
