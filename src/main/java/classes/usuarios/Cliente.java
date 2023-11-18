package classes.usuarios;

import classes.atributos.Servicio;
import classes.atributos.Servicios;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private final String cuit;
    private final String razonSocial;
    private Servicios serviciosContratados=new Servicios(new ArrayList<>());

    public Cliente(int id, String name, String cuit, String razonSocial) {
        super(id, name);
        this.cuit=cuit;
        this.razonSocial=razonSocial;
    }

    public void setServiciosContratados(Servicios serviciosContratados) {
        this.serviciosContratados = serviciosContratados;
    }
    public void setServiciosContratados(List<Servicio> servicios){
        this.serviciosContratados = new Servicios(servicios);
    }
    public void addServicio(Servicio servicio){
        this.serviciosContratados.agregarServicioSiNoExiste(servicio);
    }
    public void darBajaServicio(Servicio servicio){
        this.serviciosContratados.DarDeBajaServicioSiExiste(servicio);
    }

    public String getCuit() {
        return cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }
}
