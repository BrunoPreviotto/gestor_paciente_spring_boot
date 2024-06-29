package com.gestor_paciente.gestion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestor_paciente.gestion.dto.FamiliarDTO;
import com.gestor_paciente.gestion.mapper.FamiliarMapper;
import com.gestor_paciente.gestion.model.Familiar;
import com.gestor_paciente.gestion.repository.IFamiliar;

@Service
@Qualifier("familiar_service")
public class FamiliarServiceImplementacion implements CRUD<FamiliarDTO>{

    @Autowired
    IFamiliar repo;

    FamiliarMapper familiarMapper = new FamiliarMapper();

    @Override
    public List<FamiliarDTO> listarTodos() {
         List<FamiliarDTO> listDTO = new ArrayList<>();
       for (Familiar familiar : repo.findAll()) {
            listDTO.add(familiarMapper.aDTO(familiar));
       }
        return listDTO;
        
    }

    @Override
    public FamiliarDTO buscarPorId(Long id) {
        Familiar familiar = repo.findById(id)
        .orElseThrow(() -> new NoSuchElementException("No se encontró la entidad con el id: " + id));
        return familiarMapper.aDTO(familiar);
    }
    
    @Override
    public Long buscarIdPorDosCampos(String campo_uno, String campo_dos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarIdPorDosCampos'");
    }

    @Override
    public void guardar(FamiliarDTO objeto) {
       // repo.save(objeto);
    }

    @Override
    public void actualizar(FamiliarDTO objeto) {
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
