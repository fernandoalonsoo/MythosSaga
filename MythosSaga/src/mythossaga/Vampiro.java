package mythossaga;

import java.util.List;

public class Vampiro extends Personaje{

    private Integer edad;
    private Integer puntosSangre;

    public Vampiro(String nombre, List<Equipo> armas, Equipo armaActiva, List<Equipo> armaduras, Equipo armaduraActiva, int salud,
                   List<Modificador> debilidades, List<Modificador> fortalezas, int oro, int poder, List<Esbirro> esbirros, Integer edad, Integer puntosSangre) {
        super(nombre, salud, poder);

        this.edad = edad;
        this.puntosSangre = puntosSangre;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getPuntosSangre() {
        return puntosSangre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setPuntosSangre(Integer puntosSangre) {
        this.puntosSangre = puntosSangre;
    }
}
