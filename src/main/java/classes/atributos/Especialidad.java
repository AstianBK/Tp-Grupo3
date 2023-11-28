package classes.atributos;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
public class Especialidad implements Serializable {
    @Transient
    public static final Especialidad WINDOWS=new Especialidad("Windows");
    @Transient
    public static final Especialidad MAC_OS=new Especialidad("MacOs");
    @Transient
    public static final Especialidad LINUX=new Especialidad("Linux");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private int id;
    @Column(name = "nombre")
    private final String name;
    public Especialidad(String name){
        this.name=name;
    }
}
