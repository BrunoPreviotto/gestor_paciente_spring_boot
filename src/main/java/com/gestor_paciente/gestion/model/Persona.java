package com.gestor_paciente.gestion.model;



import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_persona")
    private long id;

    /*@NotBlank
    @Size(max = 30)
    @Column(name = "alumno")
    private String alumno;*/

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    //@Column(name = "id_nombre")
    @JoinColumn(name="id_nombre")
    private Nombre nombre;

    @NotNull
    @Column(name = "edad")
    private Integer edad;

    //@Size(max = 250)
    @Column(name = "descripcion")
    private String descripcion;

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private boolean activo;
}
