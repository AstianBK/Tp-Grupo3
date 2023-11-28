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
        this.manager.dao.findOne(id,Cliente.class).addServicio(servicio);
    }
    public void darDeBajaUnServicio(int id,Servicio servicio){
        this.manager.dao.findOne(id,Cliente.class).darBajaServicio(servicio);
    }
    public void agregarCliente(Cliente cliente){
        this.manager.dao.create(cliente);
    }

    public void removeCliente(int id){
        this.manager.dao.delete(manager.dao.findOne(id, Cliente.class));
    }
}
