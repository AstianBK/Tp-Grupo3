package classes.atributos;

public class Especialidad {
    public static final Especialidad WINDOWS=new Especialidad("Windows");
    public static final Especialidad MAC_OS=new Especialidad("MacOs");
    public static final Especialidad LINUX=new Especialidad("Linux");

    private final String name;
    public Especialidad(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
