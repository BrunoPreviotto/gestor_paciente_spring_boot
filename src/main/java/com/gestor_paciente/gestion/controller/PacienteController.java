package com.gestor_paciente.gestion.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import com.gestor_paciente.gestion.model.Nombre;
import com.gestor_paciente.gestion.model.paciente.Paciente;
import com.gestor_paciente.gestion.repository.paciente.IPacienteRepo;
import com.gestor_paciente.gestion.service.CRUD;




import jakarta.validation.Valid;


@Controller
@RequestMapping("/views/pacientes")
public class PacienteController {
    
    @Autowired
    @Qualifier("paciente_service")    
    private CRUD pacienteService;

    @Autowired
    @Qualifier("nombre_service")
    private CRUD nombreService;
    
    @Autowired 
    @Qualifier("telefono_service")
    private CRUD telefonoService;
    
    @Autowired
    @Qualifier("honorario_service")
    private CRUD honorarioService;
    
    

    /*@RequestMapping("/p")
    public String pacientes(){
       return "paciente";
    }*/
    
    @GetMapping("/")
	public String listaPacientes(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        
        
        model.addAttribute("pacientes", pacienteService.listarTodos());
		
        return "/views/pacientes/listarPacientes";
	}

    /*@GetMapping("/")
	public String pacientePorId(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
       
        model.addAttribute("paciente", pacienteService.buscarPorId(41));
		return "/views/pacientes/pacientePOrId";
	}*/

    @GetMapping("/crear")
    public String crearPaciente(Model model){
        model.addAttribute("paciente", new Paciente());
        return "/views/pacientes/crearPaciente";
    }

    
    @PostMapping("/guardar")
    public String guardarPaciente(@Validated @ModelAttribute Paciente paciente, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("paciente", paciente);
            
            return "/views/pacientes/crearPaciente";
        }
        nombreService.guardar(paciente.getNombre());
        telefonoService.guardar(paciente.getTelefono());
        honorarioService.guardar(paciente.getHonorarios());
        pacienteService.guardar(paciente);
        return "redirect:/views/pacientes/";
    }

    @GetMapping("/editar/{id}")
    public String editarPaciente(@PathVariable("id") Long idPaciente, Model model){
        Paciente paciente = (Paciente)pacienteService.buscarPorId(idPaciente);

        model.addAttribute("paciente", paciente);
        return "/views/pacientes/crearPaciente";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPaciente(@PathVariable("id") Long idPaciente){
        pacienteService.eliminar(idPaciente);
        return "redirect:/views/pacientes/";
    }

    
}
