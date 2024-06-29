package com.gestor_paciente.gestion.rest;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.gestor_paciente.gestion.model.Alumno;
import com.gestor_paciente.gestion.model.Familiar;
import com.gestor_paciente.gestion.model.Nombre;
import com.gestor_paciente.gestion.model.ResponsableAlumno;
import com.gestor_paciente.gestion.service.CRUD;
@CrossOrigin(origins = "*")
@RestController

public class RestGrupoFamiliar {
     
    @Autowired
    @Qualifier("alumno_service")
    CRUD repoAlumno;

    @Autowired
    @Qualifier("nombre_service")
    CRUD repoNombre;
    

   /* @GetMapping("/alumnos")
    public List<Alumno> verAlumnos(){
        
        return repoAlumno.listarTodos();
    }

    @PostMapping("/agregarGrupoFamiliar")
    public void createAlumno(@RequestBody Alumno alumno, @RequestBody Familiar familiar, @RequestBody ResponsableAlumno responsables) {
        Nombre nombre;
        Long idNombre = repoNombre.buscarIdPorDosCampos(alumno.getNombre().getNombre(), alumno.getNombre().getApellido());
        
        

        if(idNombre != null){
            nombre = (Nombre)repoNombre.buscarPorId(idNombre);
        }else{
            nombre = new Nombre();
            nombre.setNombre(alumno.getNombre().getNombre());
            nombre.setApellido(alumno.getNombre().getApellido());
            repoNombre.guardar(nombre);
        }
        
        Alumno crearAlumno = new Alumno();
        crearAlumno.setNombre(nombre);
        crearAlumno.setEdad(alumno.getEdad());


        repoAlumno.guardar(crearAlumno);
    }

    @GetMapping("/alumno/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable(value = "id") Long AlumnoId) {
        Alumno Alumno = (Alumno)repoAlumno.buscarPorId(AlumnoId);
        return ResponseEntity.ok().body(Alumno);
    }*/

    /*@PutMapping("/{id}")
    public ResponseEntity<Alumno> updateAlumno(@PathVariable(value = "id") Long AlumnoId,
                                                   @RequestBody Alumno AlumnoDetails) {
        Alumno Alumno = repoAlumno.findById(AlumnoId)
                .orElseThrow(() -> new ResourceNotFoundException("Alumno not found with id: " + AlumnoId));

        Alumno.setNombre(AlumnoDetails.getNombre());
        Alumno.setPrecio(AlumnoDetails.getPrecio());

        final Alumno updatedAlumno = repoAlumno.save(Alumno);
        return ResponseEntity.ok(updatedAlumno);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteAlumno(@PathVariable(value = "id") Long AlumnoId) {
        Alumno Alumno = repoAlumno.findById(AlumnoId)
                .orElseThrow(() -> new ResourceNotFoundException("Alumno not found with id: " + AlumnoId));

        repoAlumno.delete(Alumno);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    } */

}
