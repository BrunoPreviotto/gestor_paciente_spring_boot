package com.gestor_paciente.gestion.model.paciente;





import org.springframework.beans.factory.annotation.Autowired;

import com.gestor_paciente.gestion.model.Nombre;
import com.gestor_paciente.gestion.model.Telefono;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Builder.Default;




@Data
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @Column(name = "id_paciente")
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    
    @Column(name = "edad", length = 50)
    @NotNull
    private Integer edad;

    
    @Column(name = "dni")
    
    private Integer dni;
    
   

    @ManyToOne
    @JoinColumn(name = "id_nombre", referencedColumnName = "id_nombre")
    
    private Nombre nombre;
    
    @ManyToOne
    @JoinColumn(name = "id_honorario", referencedColumnName = "id_honorario")
    
    private Honorario honorarios;

    @ManyToOne
    @JoinColumn(name = "id_telefono", referencedColumnName = "id_telefono")
    
    private Telefono telefono;
    
    @OneToOne
    @JoinColumn(name = "id_diagnostico", referencedColumnName = "id_diagnostico")
    
    private Diagnostico diagnostico;
    
    @OneToOne
    @JoinColumn(name = "id_plan_tratamiento", referencedColumnName = "id_plan_tratamiento")
    private PlanTratamiento planTratamiento;

    @OneToOne
    @JoinColumn(name = "id_afiliado", referencedColumnName = "id_afiliado")
    private Afiliado afiliado;

    /*private List<Telefono> listaTelefonos;
    
    
    private Sesion sesion;
    private List<Sesion> sesiones;*/

    @OneToOne
    @JoinColumn(name = "id_obra_social_paciente", referencedColumnName = "id_obra_social_paciente")
    private ObraSocialPaciente obraSocialPaciente;
    
    public String soyElPaciente(){
        return "Soy el paciente:" + getNombre().getNombre() + getNombre().getApellido();
    }

    
}
