package classes.usuarios;

public abstract class Usuario {
    private final int id;
    private final String name;
    Usuario(int id,String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
