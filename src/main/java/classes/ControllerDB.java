package classes;

import classes.manager.TecManager;
import classes.usuarios.Tecnico;

public class ControllerDB {
    public static void inicializarTecnicos(TecManager tecManager){
        Tecnico tecnico=new Tecnico("Gabriel");
        tecManager.dao.create(tecnico);
        tecManager.dao.create(new Tecnico("Gabriela"));
        tecManager.dao.create(new Tecnico("Gabriel Marin"));
    }
}
