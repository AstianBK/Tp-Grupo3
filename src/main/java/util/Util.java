package util;

import classes.manager.ClientManager;
import classes.manager.DaoManager;
import classes.manager.IncidenteManager;
import classes.manager.TecManager;

import java.util.Scanner;

public class Util {
    public static boolean estaDentroDelRango(int valor,int min,int max){
        return valor>min && valor<=max;
    }

    public static int mostrarMsjYCargarDatos( int min, int max, String msj, Scanner scanner){
        int cc=0;
        do{
            System.out.print(msj);
            if(scanner.hasNext()){
                cc=scanner.nextInt();
            }
        }while (!Util.estaDentroDelRango(cc,min,max));
        return cc;
    }

    public static int console(int valor, Scanner scanner){
        int cc = 0;
        switch (valor){
            case 1:{
                cc=Util.mostrarMsjYCargarDatos(0,4,"Seleccione 1 - si desea despedir tecnico " +
                        "\n 2 - si  quiere contratar un tecnico " +
                        "\n 3 - ver Ranking de trabajadores por N dias\n"+
                        "\n 4 - ver Ranking de trabajadores por especialidad ",scanner);
                DaoManager.getTecManager().tecConsole(cc,scanner);
            }
            case 2:{
            }
        }
        return cc;

    }
}
