package com.gestor_paciente.gestion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gestor_paciente.gestion.dto.AlumnoDTO;
import com.gestor_paciente.gestion.mapper.AlumnoMapper;
import com.gestor_paciente.gestion.model.Alumno;
import com.gestor_paciente.gestion.repository.IAlumnoRepo;
import com.gestor_paciente.gestion.repository.IPersonaRepo;

@Service
@Qualifier("alumno_service")
public class AlumnoServiceImplementacion implements CRUD<AlumnoDTO> {

    @Autowired
    IAlumnoRepo repo;

    @Autowired
    IPersonaRepo repoPersona;

    AlumnoMapper alumnoMapper = new AlumnoMapper();
  
    @Override
    public List<AlumnoDTO> listarTodos() {
       List<AlumnoDTO> listDTO = new ArrayList<>();
       for (Alumno alumno : repo.findAll()) {
            listDTO.add(alumnoMapper.aDTO(alumno));
       }
        return listDTO;
    }

    @Override
    public AlumnoDTO buscarPorId(Long id) {
        

        
        Alumno alumno = repo.findById(id)
        .orElseThrow(() -> new NoSuchElementException("No se encontró la entidad con el id: " + id));
        return alumnoMapper.aDTO(alumno);

    }

    @Override
    public void guardar(AlumnoDTO alumno) {
        
       // repo.save(alumno);
    }

    @Override
    public void actualizar(AlumnoDTO alumno) {
        
    }

    @Override
    public void eliminar(Long id) {
        repoPersona.desactivateById(id);
    }

    @Override
    public boolean existeCampo(String campo) {
        return true;
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
