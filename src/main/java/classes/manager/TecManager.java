package classes.manager;

import classes.atributos.Especialidad;
import classes.dao.TecnicoDao;
import classes.usuarios.Tecnico;

import java.util.List;
import java.util.Scanner;

public class TecManager {
    public TecnicoDao<Tecnico> dao;

    public TecManager(){
        this.dao=new TecnicoDao<>();
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
        return id==-1 ? null  : dao.findOne(id,Tecnico.class);
    }

    public List<Tecnico> mostrarTecnicosDisponibles(List<Especialidad> especialidades){
        List<Tecnico> tecnicos1=dao.findTecnicosForDisponibilidad(Tecnico.class,especialidades);
        for (Tecnico tecnico:tecnicos1){
            System.out.print("\n|Nombre:"+tecnico.getName()+"\t||\tId:"+tecnico.getId()+"|\n");
        }
        return tecnicos1;
    }

    public boolean existeTecnico(int id,List<Tecnico> tecnicos1){
        return dao.findOne(id,Tecnico.class)!=null && tecnicos1.contains(dao.findOne(id,Tecnico.class));
    }

    public void tecConsole(int valor,Scanner scanner){
        switch (valor){
            case 1:{
                int id=-1;
                List<Tecnico> tecnicos=dao.findAll(Tecnico.class);
                do{
                    System.out.print("\nIngresar id del Tecnico seleccionado:");
                    if(scanner.hasNextInt()){
                        id=scanner.nextInt();
                    }
                }while (!existeTecnico(id,tecnicos));
                Tecnico tecnico=dao.findOne(id, Tecnico.class);
                dao.delete(tecnico);
            }
            case 2:{

            }
            case 3:{

            }
            case 4:{

            }
        }
    }

}
