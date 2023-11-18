package classes.atributos;

import java.util.ArrayList;
import java.util.List;

public class Servicios {
    List<Servicio> servicios =new ArrayList<>();
    public Servicios(List<Servicio> servicios){
        for (Servicio servicio : servicios){
            agregarServicioSiNoExiste(servicio);
        }
    }

    public void agregarServicioSiNoExiste(Servicio servicio) {
        if(this.servicios.stream().noneMatch(e->e.getName().equals(servicio.getName()))){
            this.servicios.add(servicio);
        }else {
            System.out.print("No se puede agregar ese Servicio "+ servicio.getName()+" por que ya existe");
        }
    }
    public void DarDeBajaServicioSiExiste(Servicio servicio) {
        if(this.servicios.stream().anyMatch(e->e.getName().equals(servicio.getName()))){
            this.servicios.remove(servicio);
        }else {
            System.out.print("No se puede dar de baja ese Servicio "+ servicio.getName()+" por que no existe");
        }
    }
    public boolean poseeEstaServcio(Servicio servicio){
        return this.servicios.stream().anyMatch(e->e.getName().equals(servicio.getName()));
    }

    public int getNumDeEsp(){
        return this.servicios.size();
    }
}
