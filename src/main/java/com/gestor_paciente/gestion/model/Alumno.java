package com.gestor_paciente.gestion.model;





import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Data
@Table(name = "alumnos")
@NoArgsConstructor
@AllArgsConstructor
public class Alumno extends Persona {

    
    @NotNull
    @Column(name = "numer_alumno")
    private Integer numeroDeAlumno;

    @NotNull
    @ManyToOne
    //@Column(name = "id_nombre")
    @JoinColumn(name="id_curso")
    
    private Curso curso;

    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "alumno_grupo_familiar",
        joinColumns = @JoinColumn(name = "id_alumno"),
        inverseJoinColumns = @JoinColumn(name = "id_grupo_familiar")
    )
    @JsonManagedReference
    private List<GrupoFamiliar> gruposFamiliares;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "alumno_responsable",
        joinColumns = @JoinColumn(name = "id_alumno"),
        inverseJoinColumns = @JoinColumn(name = "id_responsable")
    )
    @JsonManagedReference
    private List<ResponsableAlumno> responsables;

   
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "alumno_familiar",
        joinColumns = @JoinColumn(name = "id_alumno"),
        inverseJoinColumns = @JoinColumn(name = "id_familiar")
    )
    private List<Familiar> familiares;

    
}
