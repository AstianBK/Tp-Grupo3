package classes;

import classes.atributos.Especialidad;
import classes.atributos.Especialidades;
import classes.usuarios.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Incidente {
    private static final Incidente NO_INCIDENTE=new Incidente();
    private int id;
    private String descripcion;
    private State estadoActual=State.EN_ESPERA;
    private LocalDateTime fechaDeInicio;
    private LocalDateTime fechaDeFinalizacion;
    private LocalDateTime fechaAproxDeFinalizacion;
    private Tecnico tecnicoAsignado;
    private Cliente cliente;
    private Operador operador;
    private Especialidades especialidades=new Especialidades(new ArrayList<>());

    public Incidente(){
    }

    public void setFechaDeInicio(LocalDateTime fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Especialidades getEspecialidades() {
        return especialidades;
    }

    public State getEstadoActual() {
        return estadoActual;
    }

    public Operador getOperador() {
        return operador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Tecnico getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public int getId() {
        return id;
    }

    public void setEspecialidades(Especialidades especialidades) {
        this.especialidades = especialidades;
    }
    public void setEspecialidadesPorList(List<Especialidad> especialidades){
        this.especialidades=new Especialidades(especialidades);
    }

    public void addEspecialidad(Especialidad especialidad){
        this.especialidades.agregarEspecialidadesSiNoExiste(especialidad);
    }

    public void setEstadoActual(State estadoActual) {
        this.estadoActual = estadoActual;
    }

    public void setFechaDeFinalizacion(LocalDateTime fechaDeFinalizacion) {
        this.fechaDeFinalizacion = fechaDeFinalizacion;
    }

    public LocalDateTime getFechaDeFinalizacion() {
        return fechaDeFinalizacion;
    }

    public LocalDateTime getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTecnicoAsignado(Tecnico tecnicoAsignado) {
        this.tecnicoAsignado = tecnicoAsignado;
    }

    public void setFechaAproxDeFinalizacion(LocalDateTime fechaAproxDeFinalizacion) {
        this.fechaAproxDeFinalizacion = fechaAproxDeFinalizacion;
    }

    public LocalDateTime getFechaAproxDeFinalizacion() {
        return fechaAproxDeFinalizacion;
    }

    public void finalizado(){
        this.fechaAproxDeFinalizacion=LocalDateTime.now();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public enum State{
        EMPEZADO,
        TERMINADO,
        EN_PROCESO,
        EN_ESPERA,
        EN_BUSCA;
    }
}
