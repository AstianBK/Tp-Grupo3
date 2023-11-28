package classes.usuarios;

import classes.Incidente;
import classes.manager.TecManager;
import classes.atributos.Especialidad;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Operador implements Serializable {
    public Operador() {
        super();
    }

    public Incidente inciar( LocalDateTime fechaAproximadaDeFinalizacion, Cliente cliente, List<Especialidad> especialidades, String descri, Scanner scanner, TecManager manager){
        Incidente incidente=crearIncidente(fechaAproximadaDeFinalizacion,cliente,especialidades,descri);
        Tecnico tecnico=manager.buscarTecnico(scanner,especialidades);
        if(tecnico!=null){
            incidente.setTecnicoAsignado(tecnico);
            incidente.setEstadoActual(Incidente.State.EMPEZADO);
            tecnico.addIncidentes(incidente);
            tecnico.setDisponibilidad(Tecnico.Disponibilidad.OCUPADO);
        }
        return incidente;
    }

    public Incidente crearIncidente(LocalDateTime fechaAproximadaDeFinalizacion, Cliente cliente, List<Especialidad> especialidades,String descri){
        Incidente incidente=new Incidente();
        incidente.setCliente(cliente);
        incidente.setFechaDeInicio(LocalDateTime.now());
        incidente.setFechaAproxDeFinalizacion(fechaAproximadaDeFinalizacion);
        incidente.setEspecialidades(especialidades);
        incidente.setEstadoActual(Incidente.State.EN_BUSCA);
        incidente.setDescripcion(descri);
        return incidente;
    }
}
