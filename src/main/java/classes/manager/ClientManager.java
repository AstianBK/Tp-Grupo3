package classes.manager;

import classes.dao.ClienteDao;
import classes.usuarios.Cliente;

import java.util.Map;

public class ClientManager {

    public ClienteDao<Cliente> dao;
    public ClientManager(){
        this.dao=new ClienteDao<>();
    }

}
