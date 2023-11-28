package classes.manager;

import lombok.Data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoManager {
    static EntityManagerFactory factory = null;
    static TecManager tecManager=null;
    static ClientManager clientManager=null;
    static IncidenteManager incidenteManager=null;

    public static EntityManager getEntityManager(){
        if(factory == null)
            factory = Persistence.createEntityManagerFactory("JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
    public static TecManager getTecManager(){
        if(tecManager == null)
            tecManager = new TecManager();
        return tecManager;
    }
    public static ClientManager getClientManager(){
        if(clientManager == null)
            clientManager = new ClientManager();
        return clientManager;
    }
    public static IncidenteManager getIncidenteManager(){
        if(incidenteManager == null)
            incidenteManager = new IncidenteManager();
        return incidenteManager;
    }
}
