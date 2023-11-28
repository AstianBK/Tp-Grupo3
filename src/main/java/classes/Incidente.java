package classes;

import classes.atributos.Especialidad;
import classes.atributos.Servicio;
import classes.usuarios.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INCIDENTE")
@Data
public class Incidente implements Serializable {
    @Id
    @Column(name = "id_incidente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    @Enumerated(value = EnumType.STRING)
    private State estadoActual=State.EN_ESPERA;

    @Column(name = "fecha_de_inicio")
    private LocalDateTime fechaDeInicio;

    @Column(name = "fecha_de_finalizacion")
    private LocalDateTime fechaDeFinalizacion;

    @Column(name = "fecha_aprox_de_finalizacion")
    private LocalDateTime fechaAproxDeFinalizacion;

    @ManyToOne
    @JoinColumn(name="id_tecnico", referencedColumnName="id_tecnico")
    private Tecnico tecnicoAsignado;

    @Column(name = "cliente")
    @JoinColumn(name = "id_cliente",referencedColumnName = "id_cliente")
    private Cliente cliente;

    @Column(name = "id_servicio")
    @JoinColumn(name = "id_servicio",referencedColumnName = "id_servicio")
    private Servicio servicio;

    @Column(name = "especialidades")
    @ElementCollection
    private List<Especialidad> especialidades=new ArrayList<>();

    public Incidente(){

    }

    public void addEspecialidad(Especialidad especialidad){
        this.especialidades.add(especialidad);
    }

    public void finalizado(){
        this.fechaAproxDeFinalizacion=LocalDateTime.now();
        this.setEstadoActual(State.TERMINADO);
    }

    public void messageState(){
        System.out.print("ID:"+this.getId()+
                "\nFecha de inicio:"+this.getFechaDeInicio()+
                "\nFecha aprox de finalizacion:"+this.getFechaAproxDeFinalizacion()+
                "\nTecnico asignado:"+this.getTecnicoAsignado().getName()+
                "\nCliente:"+this.getCliente().getName()+
                "\nDescripsion:"+this.getDescripcion()+
                "\nEstado actual:"+this.getEstadoActual().name());
    }

    public enum State{
        EMPEZADO("EMPEZADO"),
        TERMINADO("TERMINADO"),
        EN_ESPERA("EN ESPERA"),
        EN_BUSCA("EN BUSCA");
        public String name;
        State(String name){
            this.name=name;
        }

        public String getName() {
            return name;
        }
    }
}
