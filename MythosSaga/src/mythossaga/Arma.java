package mythossaga;

public class Arma implements Equipo{

    private String nombre;
    private int modificadorAtaque;
    private int manos;

    public Arma(String nombre, int modificadorAtaque, int manos) {
        this.nombre = nombre;
        this.modificadorAtaque = modificadorAtaque;
        this.manos = manos;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getModificador() {
        return modificadorAtaque;
    }

    public int getManos() {
        return manos;
    }
}

