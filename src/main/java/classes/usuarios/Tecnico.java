package classes.usuarios;

import classes.Incidente;
import classes.atributos.Especialidad;
import classes.atributos.Especialidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Usuario {
    private List<Incidente> incidentes=new ArrayList<>();
    private Especialidades especialidades=new Especialidades(new ArrayList<>());
    private Incidente incidenteActual=new Incidente();

    private Disponibilidad disponibilidad=Disponibilidad.LIBRE;

    Tecnico(int id, String name) {
        super(id, name);
    }
    public boolean estaLibre(){
        return this.disponibilidad==Disponibilidad.LIBRE;
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad){
        this.disponibilidad=disponibilidad;
    }
    public void addIncidentes(Incidente incidente){
        this.incidentes.add(incidente);
    }
    public void addEspecialidad(Especialidad especialidad){
        this.especialidades.agregarEspecialidadesSiNoExiste(especialidad);
    }
    public void setEspecialidades(List<Especialidad> especialidades){
        this.especialidades=new Especialidades(especialidades);
    }
    public int getTrabajosCompletadosPorDias(int days, LocalDateTime time){
        LocalDateTime time1=time.plusDays(days);
        return (int) this.incidentes.stream().filter(e -> time1.isAfter(e.getFechaDeFinalizacion())).count();
    }

    public boolean estaCapacitado(Especialidad especialidad){
        return this.especialidades.poseeEstaEspecialidad(especialidad);
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
        OCUPADO,
        LIBRE;
    }
}
