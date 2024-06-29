package com.gestor_paciente.gestion.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.gestor_paciente.gestion.dto.FamiliarDTO;
import com.gestor_paciente.gestion.enumeradores.EnumGrupoFamiliar;
import com.gestor_paciente.gestion.model.Alumno;
import com.gestor_paciente.gestion.model.Familiar;
import com.gestor_paciente.gestion.model.Nombre;
import com.gestor_paciente.gestion.model.ResponsableAlumno;
import com.gestor_paciente.gestion.service.CRUD;
@CrossOrigin(origins = "*")
@RestController
public class RestFamiliar {
    @Autowired
    @Qualifier("familiar_service")
    CRUD repoFamiliar;

    @Autowired
    @Qualifier("nombre_service")
    CRUD repoNombre;
    

    @GetMapping("/familiares")
    public List<Alumno> verAlumnos(){
        return repoFamiliar.listarTodos();
    }

    @GetMapping("/familiar/{id}")
    public ResponseEntity<FamiliarDTO> getFamiliarById(@PathVariable(value = "id") Long familiarId) {
        FamiliarDTO familar;

        try {
            familar = (FamiliarDTO)repoFamiliar.buscarPorId(familiarId);
            return ResponseEntity.ok().body(familar);
        } catch (Exception e) {
            e.printStackTrace();
            familar = new FamiliarDTO();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(familar);
           
        }

        /*alumno = (Alumno)repoAlumno.buscarPorId(alumnoId);
        
        for (Familiar f : alumno.getFamiliares()) {
            System.out.println(f.getNombre().getNombre());
        }

        alumno = new Alumno();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(alumno);*/
        
    }

    @GetMapping("/categoria_familiar")
    public ResponseEntity<List<String>> obtenerCategoriaFamiliar(){
        
        List<String> statuses = Arrays.stream(EnumGrupoFamiliar.values())
                                     .map(Enum::name)
                                     .collect(Collectors.toList());
        return ResponseEntity.ok(statuses);
    }

    @PostMapping("/agregarFamiliar")
    public void createAlumno(@RequestBody Familiar familiar) {
        Nombre nombre;
        Long idNombre = repoNombre.buscarIdPorDosCampos(familiar.getNombre().getNombre(), familiar.getNombre().getApellido());
        
        

        if(idNombre != null){
            nombre = (Nombre)repoNombre.buscarPorId(idNombre);
        }else{
            nombre = new Nombre();
            nombre.setNombre(familiar.getNombre().getNombre());
            nombre.setApellido(familiar.getNombre().getApellido());
            repoNombre.guardar(nombre);
        }
        
        Familiar crearFamiliar = new Familiar();
        crearFamiliar.setNombre(nombre);
        crearFamiliar.setCategoria(familiar.getCategoria());
        repoFamiliar.guardar(crearFamiliar);
    }

   /* @GetMapping("/alumno/{id}")
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
    }*/

    /*@DeleteMapping("/{id}")
    public Map<String, Boolean> deleteAlumno(@PathVariable(value = "id") Long AlumnoId) {
        Alumno Alumno = repoAlumno.findById(AlumnoId)
                .orElseThrow(() -> new ResourceNotFoundException("Alumno not found with id: " + AlumnoId));

        repoAlumno.delete(Alumno);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    } */
}
