package com.gestor_paciente.gestion.service.implementacionPaciente;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestor_paciente.gestion.model.paciente.Diagnostico;
import com.gestor_paciente.gestion.model.paciente.Honorario;
import com.gestor_paciente.gestion.repository.paciente.IDiagnosticoRepo;
import com.gestor_paciente.gestion.service.CRUD;



public class DiagnosticoServiceImp implements CRUD<Diagnostico> {

    @Autowired
    IDiagnosticoRepo diagnosticoRepo;

    @Override
    public List<Diagnostico> listarTodos() {
       return diagnosticoRepo.findAll();
    }

    @Override
    public Diagnostico buscarPorId(Long id) {
        return diagnosticoRepo.findById(id).orElse(null);
    }

    @Override
    public void guardar(Diagnostico objeto) {
        diagnosticoRepo.save(objeto);
    }

    @Override
    public void actualizar(Diagnostico objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    
    @Override
    public void eliminar(Long id) {
        diagnosticoRepo.deleteById(id);
    }
    
}
