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
@Table(name = "responsable_alumno")
@NoArgsConstructor
@AllArgsConstructor
public class ResponsableAlumno extends Familiar{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_responsable")
    private long id;


    @ManyToOne
    @JoinColumn(name="id_telefono")
    private Telefono telefono;

    @Column(name = "edad")
    private Integer edad;

    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "responsable_grupo_familiar",
        joinColumns = @JoinColumn(name = "id_responsables"),
        inverseJoinColumns = @JoinColumn(name = "id_grupo_familiar")
    )
    private List<GrupoFamiliar> gruposFamiliares;

    @ManyToMany(mappedBy = "responsables", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Alumno> alumnos;

}
