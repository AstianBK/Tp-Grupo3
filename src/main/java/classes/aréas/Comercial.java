package classes.aréas;

import classes.atributos.Servicio;
import classes.manager.ClientManager;

public class Comercial {
    public ClientManager manager;
    public Comercial(ClientManager manager){
        this.manager=manager;
    }

    public void agregarServicioACliente(int id, Servicio servicio){
        this.manager.clientes.get(id).addServicio(servicio);
    }
    public void darDeBajaUnServicio(int id,Servicio servicio){

    }
}
