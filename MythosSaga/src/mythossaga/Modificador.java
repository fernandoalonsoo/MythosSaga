package mythossaga;

public abstract class Modificador {
    protected String nombre;
    protected int valor;

    public Modificador(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = Math.max(1, Math.min(valor, 5));
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

}
