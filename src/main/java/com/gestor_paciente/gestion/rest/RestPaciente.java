package com.gestor_paciente.gestion.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.gestor_paciente.gestion.model.Nombre;
import com.gestor_paciente.gestion.model.Telefono;

import com.gestor_paciente.gestion.model.paciente.Paciente;
import com.gestor_paciente.gestion.repository.paciente.IPacienteRepo;

@RestController
//@RequestMapping("RestPacientes")
public class RestPaciente {
    
   /*  @Autowired
    private IPacienteRepo repo;

    @GetMapping("/listaPacientes")
    public List<Paciente> listar(){
        return repo.findAll();
    }

    @PostMapping
    public void insertar(@RequestBody Paciente paciente, @RequestBody Nombre nombre, @RequestBody Telefono telefono){
        repo.save(paciente);
    }

    @PutMapping
    public void modificar(@RequestBody Paciente pac){
        repo.save(pac);
    }

    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable("id") Long id){
        repo.deleteById(id);
    }


    */


    
}
