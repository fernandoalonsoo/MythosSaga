package mythossaga;

import java.util.List;

public class Personaje {
    private String nombre;
    private List<Equipo> armas;
    private Equipo armaActiva;
    private List<Equipo> armaduras;
    private Equipo armaduraActiva;
    private int salud;
    private List<Modificador> debilidades;
    private List<Modificador>  fortalezas;
    private int oro;
    private int poder;
    private List<Esbirro> esbirros;

    public Personaje(String nombre, List<Equipo> armas, Equipo armaActiva, List<Equipo> armaduras, Equipo armaduraActiva,
                     int salud, List<Modificador> debilidades, List<Modificador> fortalezas, int oro, int poder, List<Esbirro> esbirros) {
        this.nombre = nombre;
        this.armas = armas;
        this.armaActiva = armaActiva;
        this.armaduras = armaduras;
        this.armaduraActiva = armaduraActiva;
        this.salud = salud;
        this.debilidades = debilidades;
        this.fortalezas = fortalezas;
        this.oro = oro;
        this.poder = poder;
        this.esbirros = esbirros;
    }

//falta habilidad especial

}
