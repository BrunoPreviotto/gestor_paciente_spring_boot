package com.gestor_paciente.gestion.security.filters;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestor_paciente.gestion.model.usuario.Usuario;
import com.gestor_paciente.gestion.security.AuthCredentials;
import com.gestor_paciente.gestion.security.UserDetailsImpl;
import com.gestor_paciente.gestion.security.jwt.JtwUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;





public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    
    private JtwUtils jwtUtils;

    public JwtAuthenticationFilter(JtwUtils jtwUtils){
        this.jwtUtils = jtwUtils;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        

        AuthCredentials authCredentials = new AuthCredentials();
        

        try {
           authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        } catch (Exception e) {
            
        }

        UsernamePasswordAuthenticationToken authenticationToken = 
            new UsernamePasswordAuthenticationToken(
                authCredentials.getEmail(), 
                authCredentials.getPassword(), 
                Collections.emptyList());
        
        return getAuthenticationManager().authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, 
                                            HttpServletResponse response, 
                                            FilterChain chain, 
                                            Authentication authResult) 
                                            throws IOException, ServletException {
        
        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        String token = jwtUtils.generateAccesToken(userDetails.getNombre(), userDetails.getUsername());
        
        response.addHeader("Authorization", token);
        response.flushBuffer();

        super.successfulAuthentication(request, response, chain, authResult);
    }
    
    
}
