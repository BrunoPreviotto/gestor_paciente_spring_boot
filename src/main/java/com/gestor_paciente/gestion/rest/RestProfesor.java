package com.gestor_paciente.gestion.rest;

public class RestProfesor {
    
   /* @Autowired
    @Qualifier("curso_service")
    CRUD repoCurso;

    @Autowired
    @Qualifier("nombre_service")
    CRUD repoNombre;

    
    

    @GetMapping("/buscarListaCurso")
    public List<Curso> listaCurso(){
        try {
            return repoCurso.listarTodos();
        } catch (Exception e) {
            List<Curso> elist = new ArrayList();
            e.printStackTrace();
            return elist;
        }
    }*/

   /* @PostMapping("/agregarAlumno")
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

        alumno = (Alumno)repoAlumno.buscarPorId(alumnoId);
        
        for (Familiar f : alumno.getFamiliares()) {
            System.out.println(f.getNombre().getNombre());
        }

        alumno = new Alumno();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(alumno);
        
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

    } */
}
