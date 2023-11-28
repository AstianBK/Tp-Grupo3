package classes.atributos;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Servicio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private int id;
    @Column(name = "nombre",length = 60)
    private final String name;
    public Servicio(String name){
        this.name=name;
    }
}
