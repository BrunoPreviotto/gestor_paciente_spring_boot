package com.gestor_paciente.gestion.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "nombres")
public class Nombre {
    
    @Id
    @Column(name = "id_nombre")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
   
    @Column(name = "nombre")
    
    private String Nombre;

    
    @Column(name = "apellido")
    
    private String apellido;
}
