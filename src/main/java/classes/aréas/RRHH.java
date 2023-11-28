package classes.aréas;

import classes.manager.TecManager;
import classes.usuarios.Tecnico;

public class RRHH {
    public TecManager manager;
    public RRHH(TecManager manager){
        this.manager=manager;
    }
    public void despedirTecnico(int id){
        manager.dao.delete(manager.dao.findOne(id, Tecnico.class));
    }
    public void contratarTecnico(Tecnico tecnico){
        manager.dao.create(tecnico);
    }
}
