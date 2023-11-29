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
        mostarList(tecnicos1);
        return tecnicos1;
    }
    public void mostarList(List<Tecnico> tecnicos){
        for (Tecnico tecnico:tecnicos){
            System.out.print("\n|Nombre:"+tecnico.getName()+"\t||\tId:"+tecnico.getId()+"|\n");
        }
    }

    public boolean existeTecnico(int id,List<Tecnico> tecnicos1){
        return dao.findOne(id,Tecnico.class)!=null && tecnicos1.contains(dao.findOne(id,Tecnico.class));
    }

    public void tecConsole(int valor,Scanner scanner){
        switch (valor){
            case 1:{
                int id=-1;
                List<Tecnico> tecnicos=dao.findAll(Tecnico.class);
                mostarList(tecnicos);
                do{
                    System.out.print("\nIngresar id del Tecnico seleccionado:");
                    if(scanner.hasNextInt()){
                        id=scanner.nextInt();
                    }
                }while (!existeTecnico(id,tecnicos));
                Tecnico tecnico=dao.findOne(id, Tecnico.class);
                dao.delete(tecnico);
                break;
            }
            case 2:{
                String s1="";
                do {
                    System.out.print("\nIngresar nombre del Tecnico:");
                    if(scanner.hasNext()){
                        s1=scanner.next();
                    }
                }while (s1.equals(""));
                Tecnico tecnico=new Tecnico(s1);
                String s2="";
                do {
                    System.out.print("\nIngresar especialidades separados por \",\" del Tecnico:");
                    if(scanner.hasNext()){
                        s2=scanner.next();
                    }
                }while (s2.equals(""));
                String[] strings=s2.split(",");
                for (String string:strings){
                    Especialidad especialidad=new Especialidad(string);
                    tecnico.addEspecialidad(especialidad);
                }
                dao.create(tecnico);
                break;
            }
            case 3:{
                int day=0;
                do {
                    System.out.print("\nIngresar dias para rankear:");
                    if(scanner.hasNextInt()){
                        day=scanner.nextInt();
                    }
                }while (day<=0);
                mostarList(dao.findRankingForDay(day, Tecnico.class));
                break;
            }
            case 4:{
                String s1="";
                do {
                    System.out.print("\nIngresar especialidad como filtro:");
                    if(scanner.hasNext()){
                        s1=scanner.next();
                    }
                }while (s1.equals(""));
                Especialidad especialidad=new Especialidad(s1);
                mostarList(dao.findRankingForEspecialidad(Tecnico.class,especialidad));
                break;
            }
        }
    }

}
