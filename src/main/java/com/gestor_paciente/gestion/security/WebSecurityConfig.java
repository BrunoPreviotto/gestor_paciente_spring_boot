package com.gestor_paciente.gestion.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                //.requestMatchers("/").permitAll()
                //.anyRequest().permitAll()
                .anyRequest().permitAll()
            )
            .formLogin(form -> form
            //.successHandler(successHandler())
                .permitAll()
            )
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //.invalidSessionUrl("/login")
                //.maximumSessions(1)
                //.expiredUrl("/login")
                //.sessionRegistry(sessionRegistry()) RESCUPERA LA INFORMACION DEL USUARIO AUTENTICADO
            )
            .build();
    }


    

   @Bean
    public UserDetailsService userDetailsService(){
        var user = User.withUsername("user")
                    .password("123")
                    .build();
        
        return new InMemoryUserDetailsManager(user);
    }

    

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception{
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder)
                .and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();        
    }

    /*public AuthenticationSuccessHandler successHandler(){
        return ((request, response, authenticated) -> {
            response.sendRedirect("/log");
        });
    }*/


    public SessionRegistry sessionRegistry(){
        return new SessionRegistryImpl();
    }
}
