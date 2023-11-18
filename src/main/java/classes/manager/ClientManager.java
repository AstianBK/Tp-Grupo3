package classes.manager;

import classes.usuarios.Cliente;

import java.util.Map;

public class ClientManager {
    public Map<Integer, Cliente> clientes;

    public ClientManager(Map<Integer,Cliente> clientes){
        this.clientes=clientes;
    }


}
