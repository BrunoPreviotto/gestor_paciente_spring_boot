package com.gestor_paciente.gestion.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cursos")
public class Curso {
    
    @Id
    @Column(name = "id_curso")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
    @NotBlank
    @Column(name = "nombre", unique = true)
    private String nombre;

    @NotBlank
    @Column(name = "descripcion")
    private String descripcion;

    @ManyToMany(mappedBy = "cursos", fetch = FetchType.EAGER)
    private List<Colaborador> colaboradores;

}
