package com.gestor_paciente.gestion.security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String email;
    private String password;
}
