package mythossaga;


public class Armadura implements Equipo {
    private String nombre;
    private int modificadorDefensa;

    public Armadura(String nombre, int modificadorDefensa) {
        this.nombre = nombre;
        this.modificadorDefensa = modificadorDefensa;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getModificador() {
        return modificadorDefensa;
    }
}