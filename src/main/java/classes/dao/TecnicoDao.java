package classes.dao;

import classes.atributos.Especialidad;
import classes.usuarios.Tecnico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TecnicoDao <T extends Tecnico> extends ObjectAbstractDao<T>{
    public List<T> findRankingForDay(int pDay,Class<T> tClass){
        List<T> list = findAll(tClass).stream().filter(
                e->e.realizoTrabajoPorDias(pDay,LocalDateTime.now()))
                .collect(Collectors.toList());
        return list;
    }
    public List<T> findTecnicosForDisponibilidad(Class<T> tClass, List<Especialidad> especialidades){
        List<T> list=findAll(tClass).stream().filter(
                e->e.estaLibre() && e.estaCapacitadoParaElTrabajo(especialidades))
                .collect(Collectors.toList());
        return list;
    }
    public List<T> findRankingForEspecialidad(Class<T> tClass,Especialidad especialidad){
        List<T> list=findAll(tClass).stream().filter(
                e->e.realizoTrabajoConEsaEspecialidad(especialidad)).toList();
        return list;
    }
}
