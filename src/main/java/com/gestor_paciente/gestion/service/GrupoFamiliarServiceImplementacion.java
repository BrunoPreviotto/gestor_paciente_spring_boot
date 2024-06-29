package com.gestor_paciente.gestion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestor_paciente.gestion.model.GrupoFamiliar;

@Service
@Qualifier("grupo_familiar_service")
public class GrupoFamiliarServiceImplementacion implements CRUD<GrupoFamiliar>{

    @Override
    public List<GrupoFamiliar> listarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

    @Override
    public GrupoFamiliar buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public Long buscarIdPorDosCampos(String campo_uno, String campo_dos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarIdPorDosCampos'");
    }

    @Override
    public void guardar(GrupoFamiliar objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

    @Override
    public void actualizar(GrupoFamiliar objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public boolean existeCampo(String campo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existeCampo'");
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
