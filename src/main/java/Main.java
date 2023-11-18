import classes.Incidente;
import classes.atributos.Especialidad;
import classes.manager.ClientManager;
import classes.manager.TecManager;
import classes.usuarios.Cliente;
import classes.usuarios.Operador;
import classes.usuarios.Tecnico;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cc = 0;
        Map<Integer,Tecnico> tecnicos=new HashMap<>();
        Map<Integer, Cliente> clientes=new HashMap<>();
        List<Especialidad> especialidades=new ArrayList<>();
        especialidades.add(Especialidad.WINDOWS);
        especialidades.add(Especialidad.LINUX);
        Tecnico tecnico=new Tecnico(0,"Martin");
        tecnico.setEspecialidades(especialidades);
        Cliente cliente=new Cliente(1,"Nicole","20435344534","PepiIn");
        tecnicos.put(tecnico.getId(),tecnico);
        clientes.put(cliente.getId(),cliente);
        TecManager manager=new TecManager(tecnicos);
        ClientManager clientManager=new ClientManager(clientes);
        Operador operador=new Operador(2,"Pepito");
        System.out.print("¿Hola en que puedo ayudarlo?");
        do{
            System.out.print("Seleccione 1 - si desea reportar un incidente " +
                    "\n 2 - si desea dar de baja algun servicio " +
                    "\n 3 - si desea contratar un nuevo servicios");
            if(scanner.hasNext()){
                cc=scanner.nextInt();
            }
        }while (cc<=0 || cc>3);
        switch (cc){
            case 1:{
                Incidente incidente = operador.inciar(0, LocalDateTime.of(2023,12,7,14,2),cliente,especialidades,"pepe",scanner,manager);
                if (incidente!=null){
                    System.out.print("\nIncidente creado\n");
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
    }
}