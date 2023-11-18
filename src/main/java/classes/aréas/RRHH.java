package classes.aréas;

import classes.manager.TecManager;
import classes.usuarios.Tecnico;

public class RRHH {
    public TecManager manager;
    RRHH(TecManager manager){
        this.manager=manager;
    }
    public void despedirTecnico(int id){
        manager.tecnicos.remove(id);
    }
    public void contratarTecnico(Tecnico tecnico){
        manager.tecnicos.put(tecnico.getId(),tecnico);
    }
}
