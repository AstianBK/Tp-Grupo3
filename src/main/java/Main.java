import classes.ControllerDB;
import classes.Incidente;
import classes.manager.ClientManager;
import classes.manager.DaoManager;
import classes.manager.IncidenteManager;
import classes.manager.TecManager;
import classes.usuarios.Cliente;
import classes.usuarios.Operador;
import util.Util;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cc = 0;
        TecManager manager= DaoManager.getTecManager();
        ClientManager clientManager=DaoManager.getClientManager();
        IncidenteManager incidenteManager=DaoManager.getIncidenteManager();
        ControllerDB.inicializarTecnicos(manager);
        Cliente cliente=new Cliente("Walter");
        clientManager.dao.create(cliente);

        Operador operador=new Operador();
        System.out.print("¿Hola en que puedo ayudarlo?");
        cc=Util.mostrarMsjYCargarDatos(0,4,"Seleccione 1 - si desea reportar un incidente " +
                "\n 2 - si desea dar de baja algun servicio " +
                "\n 3 - si desea contratar un nuevo servicios\n"
                ,scanner);

        switch (cc){
            case 1:{
                Incidente incidente = operador.inciar( LocalDateTime.of(2023,new Random().nextInt(1,6),new Random().nextInt(1,28),14,2),cliente,new ArrayList<>(),"pepe",scanner,manager);
                if (incidente!=null){
                    System.out.print("\nIncidente creado\n");
                    incidenteManager.save(incidente);
                    manager.dao.update(incidente.getTecnicoAsignado());
                    incidente.messageState();
                }
            }
            case 2:{
                //Sin iniciar
            }
            case 3:{
                //sin iniciar
            }
        }
        int cc1=Util.mostrarMsjYCargarDatos(0,4,"1 - Si eres de RRHH" +
                "\n 2 - Si eres Tecnico \n 3 - Si perteneces al Area Comercial \n 4 - Si eres Cliente"
                ,scanner);
        Util.console(cc1,scanner);

    }

}