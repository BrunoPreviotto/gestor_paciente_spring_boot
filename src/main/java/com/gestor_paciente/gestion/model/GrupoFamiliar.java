package com.gestor_paciente.gestion.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
@Table(name = "grupo_familiar")
@NoArgsConstructor
@AllArgsConstructor
public class GrupoFamiliar {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_grupo_familiar")
    private Long id;
    
    @NotNull
    private String nombre;
    // Otros atributos y métodos

    @ManyToMany(mappedBy = "gruposFamiliares", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Alumno> alumnos;

    @ManyToMany(mappedBy = "gruposFamiliares", fetch = FetchType.EAGER)
    private List<Familiar> familiares;

    @ManyToMany(mappedBy = "gruposFamiliares", fetch = FetchType.EAGER)
    private List<ResponsableAlumno> responsables;
}
