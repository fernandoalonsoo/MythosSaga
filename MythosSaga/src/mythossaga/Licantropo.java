package mythossaga;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Licantropo extends Personaje implements Serializable {

    private Integer rabia;

    public Licantropo(String nombre) {
        super(nombre);
    }

    public Licantropo(String nombre, Integer rabia) {
        super(nombre);
        this.rabia = rabia;
    }

    public Licantropo(String nombre, int salud, int poder, Integer rabia) {
        super(nombre, salud, poder);
        this.rabia = rabia;
    }

    public Licantropo(String nombre, HashMap<String, Equipo> armas, Equipo[] armaActiva, HashMap<String, Equipo> armaduras, Equipo armaduraActiva, int salud, List<Modificador> debilidades, List<Modificador> fortalezas, double oro, int poder, List<Esbirro> esbirros, Integer rabia) {
        super(nombre, armas, armaActiva, armaduras, armaduraActiva, salud, debilidades, fortalezas, oro, poder, esbirros);
        this.rabia = rabia;
    }

    public Integer getRabia() {
        return rabia;
    }

    public void setRabia(Integer rabia) {
        this.rabia = rabia;
    }
}
