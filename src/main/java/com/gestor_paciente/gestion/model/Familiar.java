package com.gestor_paciente.gestion.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.gestor_paciente.gestion.enumeradores.EnumGrupoFamiliar;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "familiar")
@Inheritance(strategy = InheritanceType.JOINED)
public class Familiar extends Persona{

    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_familiar")
    private long id;

    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "familiar_grupo_familiar",
        joinColumns = @JoinColumn(name = "id_familiar"),
        inverseJoinColumns = @JoinColumn(name = "id_grupo_familiar")
    )
    private List<GrupoFamiliar> gruposFamiliares;

    @ManyToMany(mappedBy = "familiares", fetch = FetchType.EAGER)
    //@JsonBackReference
    private List<Alumno> alumnos;
    

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", columnDefinition = "VARCHAR(20) DEFAULT 'VINCULADO'")
    private EnumGrupoFamiliar categoria;

}
