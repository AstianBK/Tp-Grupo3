package classes.manager;

import classes.Incidente;
import classes.dao.IncidenteDao;

public class IncidenteManager extends DaoManager{
    public IncidenteDao<Incidente> dao;
    public IncidenteManager(){
        this.dao=new IncidenteDao<>();
    }

    public void save(Incidente incidente){
        dao.create(incidente);
    }
}
