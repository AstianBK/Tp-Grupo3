package classes.exeption;

import classes.atributos.Especialidad;

public class ExeptionEspecialidadDuplicada extends Exception{
    Especialidad especialidad;

    public ExeptionEspecialidadDuplicada(Especialidad especialidad){
        this.especialidad=especialidad;
    }
}
