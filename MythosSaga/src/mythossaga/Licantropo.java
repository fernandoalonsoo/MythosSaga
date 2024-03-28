package mythossaga;

import java.util.List;

public class Licantropo extends Personaje{

    private Integer rabia;

    public Licantropo(String nombre, List<Equipo> armas, Equipo armaActiva, List<Equipo> armaduras, Equipo armaduraActiva, int salud,
                      List<Modificador> debilidades, List<Modificador> fortalezas, int oro, int poder, List<Esbirro> esbirros, Integer rabia) {
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
