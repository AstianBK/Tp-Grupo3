package classes.usuarios;

import classes.Incidente;
import classes.atributos.Especialidad;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TECNICOS")
@Data
@NoArgsConstructor(force = true)
public class Tecnico implements Serializable {
    @Id
    @Column(name = "id_tecnico")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private final String name;

    @OneToMany
    @Column(name = "incidentes")
    private List<Incidente> incidentes=new ArrayList<>();

    @Transient
    private List<Especialidad> especialidades=new ArrayList<>();

    @Column(name = "disponibilidad")
    @Enumerated(value = EnumType.STRING)
    private Disponibilidad disponibilidad=Disponibilidad.LIBRE;

    public Tecnico(String name) {
        super();
        this.name=name;
    }
    public boolean estaLibre(){
        return this.disponibilidad==Disponibilidad.LIBRE;
    }
    public void addIncidentes(Incidente incidente){
        this.incidentes.add(incidente);
    }
    public void addEspecialidad(Especialidad especialidad){
        this.especialidades.add(especialidad);
    }
    public int getTrabajosCompletadosPorDias(int days, LocalDateTime time){
        return (int) this.incidentes.stream().filter(e -> time.isAfter(e.getFechaDeFinalizacion().plusDays(days))).count();
    }
    public boolean realizoTrabajoPorDias(int pDay,LocalDateTime time){
        return getTrabajosCompletadosPorDias(pDay,time)==0;
    }

    public boolean estaCapacitado(Especialidad especialidad){
        return this.especialidades.contains(especialidad);
    }
    public boolean estaCapacitadoParaElTrabajo(List<Especialidad> especialidades){
        int i=0;
        int j=especialidades.size();
        for (Especialidad especialidad:especialidades){
            if(estaCapacitado(especialidad)){
                i++;
            }
        }
        return i==j;
    }

    enum Disponibilidad{
        OCUPADO("OCUPADO"),
        LIBRE("LIBRE");
        private String name;
        Disponibilidad(String name){
            this.name=name;
        }

        public String getName() {
            return name;
        }
    }
}
