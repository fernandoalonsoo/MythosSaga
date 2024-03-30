package mythossaga;

import java.io.Serializable;
import java.util.List;

public class Licantropo extends Personaje implements Serializable {

    private Integer rabia;

    public Licantropo(String nombre, List<Equipo> armas, Equipo armaActiva, List<Equipo> armaduras, Equipo armaduraActiva, int salud,
                      List<Modificador> debilidades, List<Modificador> fortalezas, int oro, int poder, List<Esbirro> esbirros, Integer rabia) {
        super(nombre, salud, poder);
        this.rabia = rabia;
    }

    public Integer getRabia() {
        return rabia;
    }

    public void setRabia(Integer rabia) {
        this.rabia = rabia;
    }
}
