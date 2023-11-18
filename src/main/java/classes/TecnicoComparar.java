package classes;

import classes.atributos.Especialidad;
import classes.usuarios.Tecnico;

import java.util.List;

public interface TecnicoComparar {
    boolean comparar(List<Tecnico> tecnicos, List<Especialidad> especialidades);
}
