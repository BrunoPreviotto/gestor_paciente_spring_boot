package com.gestor_paciente.gestion.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nombres")
public class Nombre {
    
    @Id
    @Column(name = "id_nombre")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
    @NotBlank
    @Column(name = "nombre", unique = true)
    private String nombre;

    @NotBlank
    @Column(name = "apellido", unique = true)
    private String apellido;
}
