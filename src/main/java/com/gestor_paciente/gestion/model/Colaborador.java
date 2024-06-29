package com.gestor_paciente.gestion.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "colaboradores")
@NoArgsConstructor
@AllArgsConstructor
public class Colaborador extends Persona{
    
    @ManyToOne
    @JoinColumn(name="id_telefono")
    private Telefono telefono;

    @ManyToMany
    @JoinTable(
        name = "colaborador_curso",
        joinColumns = @JoinColumn(name = "id_colaborador"),
        inverseJoinColumns = @JoinColumn(name = "id_curso")
    )
    @Column(name = "id_curso")
    private List<Curso> cursos;

}
