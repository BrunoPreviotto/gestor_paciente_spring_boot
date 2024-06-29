package com.gestor_paciente.gestion.service.implementacionPaciente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.gestor_paciente.gestion.model.paciente.Paciente;
import com.gestor_paciente.gestion.repository.paciente.IPacienteRepo;
import com.gestor_paciente.gestion.service.CRUD;

@Service
//@Qualifier("paciente_service")
public class PacienteServiceImplement /*implements CRUD<Paciente>*/{
   /*  @Autowired
    private IPacienteRepo repo;

   
    
    @Override
    public List<Paciente> listarTodos() {
        return (List<Paciente>)repo.findAll();
    }

    @Override
    public Paciente buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void guardar(Paciente paciente) {
        repo.save(paciente);
    }

    @Override
    public void actualizar(Paciente paciente) {
        
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id); 
    }*/
    
}
