package classes.aréas;

import classes.atributos.Servicio;
import classes.manager.ClientManager;
import classes.usuarios.Cliente;

public class Comercial {
    public ClientManager manager;
    public Comercial(ClientManager manager){
        this.manager=manager;
    }
    public void agregarServicioACliente(int id, Servicio servicio){
        this.manager.clientes.get(id).addServicio(servicio);
    }
    public void darDeBajaUnServicio(int id,Servicio servicio){
        this.manager.clientes.get(id).darBajaServicio(servicio);
    }
    public void agregarCliente(Cliente cliente){
        this.manager.clientes.put(cliente.getId(),cliente);
    }

    public void removeCliente(int id){
        this.manager.clientes.remove(id);
    }
}
