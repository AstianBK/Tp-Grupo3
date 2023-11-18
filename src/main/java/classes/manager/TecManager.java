package classes.manager;

import classes.atributos.Especialidad;
import classes.usuarios.Tecnico;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TecManager {
    public Map<Integer,Tecnico> tecnicos;

    public TecManager(Map<Integer, Tecnico> tecnicoMap){
        this.tecnicos=tecnicoMap;
    }

    public Tecnico buscarTecnico(Scanner scanner, List<Especialidad> especialidades){
        int id=-1;
        List<Tecnico> tecnicos1=mostrarTecnicosDisponibles(especialidades);
        if(!tecnicos1.isEmpty()){
            do{
                System.out.print("\nIngresar id del Tecnico seleccionado:");
                if(scanner.hasNextInt()){
                    id=scanner.nextInt();
                }
            }while (!existeTecnico(id,tecnicos1));
        }else {
            System.out.print("\n No hay tecnicos disponibles o capacitados para solucionar el incidente.");
        }
        return id==-1 ? null  : buscarPorId(id);
    }

    public List<Tecnico> mostrarTecnicosDisponibles(List<Especialidad> especialidades){
        List<Tecnico> tecnicos1=this.tecnicos.values().stream().filter(e->e.estaLibre() && e.estaCapacitadoParaElTrabajo(especialidades)).collect(Collectors.toList());
        for (Tecnico tecnico:tecnicos1){
            System.out.print("\n"+tecnico.getName()+"-\t-"+tecnico.getId()+"\n");
        }
        return tecnicos1;
    }

    public Tecnico buscarPorId(int id){
        return tecnicos.get(id);
    }
    public boolean existeTecnico(int id,List<Tecnico> tecnicos1){
        if(id<0){
            return false;
        }
        return buscarPorId(id)==null && tecnicos1.contains(buscarPorId(id));
    }

}
