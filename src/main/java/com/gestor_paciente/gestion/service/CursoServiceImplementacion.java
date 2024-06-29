package com.gestor_paciente.gestion.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.gestor_paciente.gestion.dto.CursoDTO;
import com.gestor_paciente.gestion.mapper.CursoMapper;
import com.gestor_paciente.gestion.model.Curso;

import com.gestor_paciente.gestion.repository.ICursoRepo;
import com.gestor_paciente.gestion.service.CRUD;

@Service
@Qualifier("curso_service")
public class CursoServiceImplementacion implements CRUD<CursoDTO>{
    @Autowired
    private ICursoRepo repo;

    @Autowired
    private CursoMapper cursoMapper;

   
    @Override
    public List<CursoDTO> listarTodos() {
         List<CursoDTO> listDTO = new ArrayList<>();
       for (Curso curso : repo.findAll()) {
            listDTO.add(cursoMapper.aDTO(curso));
       }
        return listDTO;
    }

    @Override
    public CursoDTO buscarPorId(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'buscarIdPorDosCampos'");
        //return repo.findById(id).orElseThrow(() -> new ResourceAccessException("Curso no encontrado"));
    }

    @Override
    public Long buscarIdPorDosCampos(String campo_uno, String campo_dos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarIdPorDosCampos'");
    }

    @Override
    public void guardar(CursoDTO objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardar'");
    }

    @Override
    public void actualizar(CursoDTO objeto) {
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
         return repo.findIdByNombre(campo_uno);
    }

    @Override
    public void eliminarParcial(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarParcial'");
    }
}
