package classes.usuarios;

import classes.Incidente;
import classes.manager.TecManager;
import classes.atributos.Especialidad;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Operador extends Usuario{
    public Operador(int id, String name) {
        super(id, name);
    }

    public Incidente inciar(int id, LocalDateTime fechaAproximadaDeFinalizacion, Cliente cliente, List<Especialidad> especialidades, String descri, Scanner scanner, TecManager manager){
        Incidente incidente=crearIncidente(id,fechaAproximadaDeFinalizacion,cliente,especialidades,descri);
        Tecnico tecnico=manager.buscarTecnico(scanner,especialidades);
        if(tecnico!=null){
            incidente.setTecnicoAsignado(tecnico);
            incidente.setEstadoActual(Incidente.State.EMPEZADO);
            tecnico.addIncidentes(incidente);
        }
        return incidente;
    }

    public Incidente crearIncidente(int id, LocalDateTime fechaAproximadaDeFinalizacion, Cliente cliente, List<Especialidad> especialidades,String descri){
        Incidente incidente=new Incidente();
        incidente.setOperador(this);
        incidente.setCliente(cliente);
        incidente.setId(id);
        incidente.setFechaDeInicio(LocalDateTime.now());
        incidente.setFechaAproxDeFinalizacion(fechaAproximadaDeFinalizacion);
        incidente.setEspecialidadesPorList(especialidades);
        incidente.setEstadoActual(Incidente.State.EN_BUSCA);
        incidente.setDescripcion(descri);
        return incidente;
    }
}
