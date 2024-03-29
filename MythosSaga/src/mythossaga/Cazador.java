package mythossaga;

import java.util.List;

public class Cazador extends Personaje{
    private Integer voluntad;

    public Cazador(String nombre, List<Equipo> armas, Equipo armaActiva, List<Equipo> armaduras, Equipo armaduraActiva, int salud,
                   List<Modificador> debilidades, List<Modificador> fortalezas, int oro, int poder, List<Esbirro> esbirros, Integer voluntad) {
        super(nombre, salud, poder);
        this.voluntad = voluntad;
    }
}
