package mythossaga;

public class Armadura extends Equipo {
    public Armadura(String nombre, int modificador) {
        super(nombre, modificador);
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", Modificador de defensa: " + this.modificador;
    }
}
