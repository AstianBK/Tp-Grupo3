package classes;

import classes.usuarios.Tecnico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RankingTecnicos implements Serializable {
    private List<Tecnico> tecnicos;
    public RankingTecnicos(){
        this.tecnicos=new ArrayList<>();
    }
}
