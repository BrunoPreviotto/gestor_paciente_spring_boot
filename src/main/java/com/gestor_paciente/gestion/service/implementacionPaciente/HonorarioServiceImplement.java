package com.gestor_paciente.gestion.service.implementacionPaciente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestor_paciente.gestion.model.paciente.Honorario;
import com.gestor_paciente.gestion.repository.paciente.IHonorarioRepo;
import com.gestor_paciente.gestion.service.CRUD;


@Service
@Qualifier("honorario_service")
public class HonorarioServiceImplement implements CRUD<Honorario>{

    @Autowired
    private IHonorarioRepo repo;

    @Override
    public List<Honorario> listarTodos() {
        return (List<Honorario>) repo.findAll();
    }

    @Override
    public Honorario buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void guardar(Honorario honorario) {
        repo.save(honorario);
    }

    @Override
    public void actualizar(Honorario honorario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
    
}
