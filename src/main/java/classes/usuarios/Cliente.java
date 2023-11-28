package classes.usuarios;

import classes.atributos.Servicio;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "CLIENTE")
@Entity
@Data
@NoArgsConstructor(force = true)
public class Cliente implements Serializable {
    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nombre")
    private final String name;
    private String cuit;
    private String razonSocial;
    @Transient
    private List<Servicio> serviciosContratados=new ArrayList<>();

    public Cliente( String name) {
        super();
        this.name = name;

    }
    public void addServicio(Servicio servicio){
        this.serviciosContratados.add(servicio);
    }
    public void darBajaServicio(Servicio servicio){
        this.serviciosContratados.remove(servicio);
    }
}
