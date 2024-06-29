package com.gestor_paciente.gestion.controller;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.gestor_paciente.gestion.model.paciente.Paciente;

import ch.qos.logback.core.model.Model;

@Controller
public class HomeController {

    /*@Autowired
    private PacienteController  pacienteController;
    
    @GetMapping("/")
    public String index(){
        return "home";
    }

    @GetMapping("/redireccionar")
    public RedirectView redireccionarPaciente() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/paciente");
        return redirectView;
    }

    @GetMapping("/log")
    public String log(){
        return "login";
    }*/

   
    
}
