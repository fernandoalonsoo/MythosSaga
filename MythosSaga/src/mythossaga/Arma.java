package mythossaga;

public class Arma extends Equipo {
    private int manos;

    public Arma(String nombre, int modificador, int manos) {
        super(nombre, modificador);
        this.manos = manos;
    }

    public int getManos() {
        return manos;
    }
}
