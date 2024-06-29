package com.gestor_paciente.gestion.rest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.gestor_paciente.gestion.dto.AlumnoDTO;
import com.gestor_paciente.gestion.model.Alumno;
import com.gestor_paciente.gestion.model.Curso;
import com.gestor_paciente.gestion.model.Familiar;
import com.gestor_paciente.gestion.model.Nombre;

import com.gestor_paciente.gestion.service.CRUD;
@CrossOrigin(origins = "*")
@RestController
//@RequestMapping("/alumnos")
public class RestAlumno {
    
    @Autowired
    @Qualifier("alumno_service")
    CRUD repoAlumno;

    @Autowired
    @Qualifier("nombre_service")
    CRUD repoNombre;

    @Autowired
    @Qualifier("curso_service")
    CRUD repoCurso;
    

    @GetMapping("/buscarListaAlumnos")
    public List<Alumno> verAlumnos(){
        try {
            return repoAlumno.listarTodos();
        } catch (Exception e) {
            List<Alumno> elist = new ArrayList<>();
            e.printStackTrace();
            return elist;
        }
    }

    @PostMapping("/agregarAlumno")
    public void createAlumno(@RequestBody Alumno alumno) {
        try {
            Nombre nombre;
            Long idNombre = repoNombre.buscarIdPorDosCampos(alumno.getNombre().getNombre(), alumno.getNombre().getApellido());
            
            Curso curso;
            Long idCurso = repoCurso.buscarIdPorUnCampo(alumno.getCurso().getNombre());

            
            
            curso = (Curso)repoCurso.buscarPorId(idCurso);
            if(idNombre != null){
                nombre = (Nombre)repoNombre.buscarPorId(idNombre);
            }else{
                nombre = new Nombre();
                nombre.setNombre(alumno.getNombre().getNombre());
                nombre.setApellido(alumno.getNombre().getApellido());
                repoNombre.guardar(nombre);
            }

            if(idNombre != null){
                nombre = (Nombre)repoNombre.buscarPorId(idNombre);
            }else{
                nombre = new Nombre();
                nombre.setNombre(alumno.getNombre().getNombre());
                nombre.setApellido(alumno.getNombre().getApellido());
                repoNombre.guardar(nombre);
            }
            
            Alumno crearAlumno = new Alumno();
            //crearAlumno.setId(0);
            crearAlumno.setNombre(nombre);
            crearAlumno.setEdad(alumno.getEdad());
            crearAlumno.setDescripcion(alumno.getDescripcion());
            crearAlumno.setNumeroDeAlumno(alumno.getNumeroDeAlumno());
            crearAlumno.setCurso(curso);
            //crearAlumno.setGruposFamiliares(alumno.getGruposFamiliares());
            //crearAlumno.setResponsables(res);
            repoAlumno.guardar(crearAlumno);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/alumno/{id}")
    public ResponseEntity<AlumnoDTO> getAlumnoById(@PathVariable(value = "id") Long alumnoId) {
        AlumnoDTO alumno;

        try {
            alumno = (AlumnoDTO)repoAlumno.buscarPorId(alumnoId);
            return ResponseEntity.ok().body(alumno);
        } catch (Exception e) {
            e.printStackTrace();
            alumno = new AlumnoDTO();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(alumno);
           
        }

        /*alumno = (Alumno)repoAlumno.buscarPorId(alumnoId);
        
        for (Familiar f : alumno.getFamiliares()) {
            System.out.println(f.getNombre().getNombre());
        }

        alumno = new Alumno();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(alumno);*/
        
    }

    @PutMapping("/actualizarAlumno/{id}")
    public ResponseEntity<String> updateAlumno(@PathVariable(value = "id") Long alumnoId, @RequestBody Alumno alumnoDetails) {
        
        
        
        try {
            Alumno alumno = (Alumno)repoAlumno.buscarPorId(alumnoId);
            Nombre nombre;
            Long idNombre = repoNombre.buscarIdPorDosCampos(alumnoDetails.getNombre().getNombre(), alumnoDetails.getNombre().getApellido());
            
            if(idNombre != null){
                nombre = (Nombre)repoNombre.buscarPorId(idNombre);
            }else{
                nombre = new Nombre();
                nombre.setNombre(alumnoDetails.getNombre().getNombre());
                nombre.setApellido(alumnoDetails.getNombre().getApellido());
                repoNombre.guardar(nombre);
               
            }

            
            alumno.setNombre(nombre);
            alumno.setEdad(alumnoDetails.getEdad());
            
            alumno.setNumeroDeAlumno(alumnoDetails.getNumeroDeAlumno());
            alumno.setCurso(alumnoDetails.getCurso());
            alumno.setGruposFamiliares(alumnoDetails.getGruposFamiliares());                                           
            alumno.setResponsables(alumnoDetails.getResponsables());
            alumno.setFamiliares(alumnoDetails.getFamiliares());
            repoAlumno.guardar(alumno);
            return ResponseEntity.ok("Alumno actualizado con éxito");
        } catch (Exception e) {
           
            return ResponseEntity.ok("No se pudo actualizar al alumno");
        }


        // return ResponseEntity.ok("No se pudo actualizar al alumno");
    }

    @DeleteMapping("/borrarAlumno/{id}")
    public Map<String, Boolean> deleteAlumno(@PathVariable(value = "id") Long id) {
       try {
        repoAlumno.eliminar(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
       } catch (Exception e) {
        e.printStackTrace();
        return null;
       }

    } 



}
