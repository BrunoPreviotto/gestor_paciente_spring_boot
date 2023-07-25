package com.gestor_paciente.gestion.model.paciente;

import com.gestor_paciente.gestion.model.obra_social.ObraSocial;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "obras_sociales_paciente")
public class ObraSocialPaciente {
    
    @Id
    @Column(name = "id_obra_social_paciente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_afiliado", referencedColumnName = "id_afiliado")
    private Afiliado afiliado;

    @OneToOne
    @JoinColumn(name = "id_obra_social", referencedColumnName = "id_obra_social")
    private ObraSocial obraSocial;
    
}
