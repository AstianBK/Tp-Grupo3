import classes.manager.TecManager;
import classes.usuarios.Tecnico;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer,Tecnico> tecnicos=new HashMap<>();
        TecManager manager=new TecManager(tecnicos);
        System.out.print("hola");
    }
}