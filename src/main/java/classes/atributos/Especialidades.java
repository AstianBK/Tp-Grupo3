package classes.atributos;

import java.util.ArrayList;
import java.util.List;

public class Especialidades {
    List<Especialidad> especialidades=new ArrayList<>();
    public Especialidades(List<Especialidad> especialidades){
        for (Especialidad especialidad:especialidades){
            agregarEspecialidadesSiNoExiste(especialidad);
        }
    }

    public void agregarEspecialidadesSiNoExiste(Especialidad especialidad) {
        if(this.especialidades.stream().noneMatch(e->e.getName().equals(especialidad.getName()))){
            this.especialidades.add(especialidad);
        }else {
            System.out.print("No se puede agregar esa la Especialidad "+especialidad.getName()+" por que ya existe");
        }
    }
    public boolean poseeEstaEspecialidad(Especialidad especialidad){
        return this.especialidades.stream().anyMatch(e->e.getName().equals(especialidad.getName()));
    }

    public int getNumDeEsp(){
        return this.especialidades.size();
    }
}
