package com.gestor_paciente.gestion.model.usuario;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;


import com.gestor_paciente.gestion.model.Email;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private int id;

    @NotBlank
    @Size(max = 30)
    @Column(name = "usuario")
    private String usuario;

    @NotBlank
    @Column(name = "contraseña")
    private String contraseña;

    @jakarta.validation.constraints.Email
    @Column(name = "email")
    @NotBlank
    @Size(max = 80)
    private String email;

    @ManyToMany(cascade = CascadeType.PERSIST, targetEntity = Rol.class, fetch = FetchType.EAGER)
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private Set<Rol> roles;


    
    

}
