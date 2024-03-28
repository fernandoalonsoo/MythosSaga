package mythossaga;

public abstract class Equipo {
    protected String nombre;
    protected int modificador;

    public Equipo(String nombre, int modificador) {
        this.nombre = nombre;
        this.modificador = modificador;
    }

    public String getNombre() {
        return nombre;
    }

    public int getModificador() {
        return modificador;
    }
}
