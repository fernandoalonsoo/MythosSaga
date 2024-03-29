package mythossaga;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Personaje {
    private String nombre;
    private HashMap<String, Equipo> armas;
    private Equipo[] armaActiva;

    private HashMap<String, Equipo> armaduras;
    private Equipo armaduraActiva;
    private int salud;
    private List<Modificador> debilidades;
    private List<Modificador>  fortalezas;
    private double oro;
    private int poder;
    private List<Esbirro> esbirros;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<String, Equipo> getArmas() {
        return armas;
    }

    public void setArmas(HashMap<String, Equipo> armas) {
        this.armas = armas;
    }

    public Equipo[] getArmaActiva() {
        return armaActiva;
    }
    public void setArmaActiva(Equipo... equipos){
        Arrays.fill(this.armaActiva, null);

        // Agrega los nuevos equipos
        int index = 0;
        for (Equipo equipo : equipos) {
            this.armaActiva[index++] = equipo;
            // Verifica si hemos alcanzado el límite del array
            if (index >= this.armaActiva.length) {
                break;
            }
        }
    }
    public HashMap<String, Equipo> getArmaduras() {
        return armaduras;
    }

    public void setArmaduras(HashMap<String, Equipo> armaduras) {
        this.armaduras = armaduras;
    }

    public Equipo getArmaduraActiva() {
        return armaduraActiva;
    }

    public void setArmaduraActiva(Equipo armaduraActiva) {
        this.armaduraActiva = armaduraActiva;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public List<Modificador> getDebilidades() {
        return debilidades;
    }

    public void setDebilidades(List<Modificador> debilidades) {
        this.debilidades = debilidades;
    }

    public List<Modificador> getFortalezas() {
        return fortalezas;
    }

    public void setFortalezas(List<Modificador> fortalezas) {
        this.fortalezas = fortalezas;
    }

    public double getOro() {
        return oro;
    }

    public void setOro(double oro) {
        this.oro = oro;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public List<Esbirro> getEsbirros() {
        return esbirros;
    }

    public void setEsbirros(List<Esbirro> esbirros) {
        this.esbirros = esbirros;
    }

    public Personaje(String nombre, int salud, int poder) {
        this.nombre = nombre;
        this.salud = salud;
        this.oro = 100;
        this.poder = poder;
        this.armaActiva = new Equipo[2];
        this.armaduras = new HashMap<>();
        this.armas = new HashMap<>();
    }

    public Personaje() {

    }

    public void addArmas(Arma arma) {
        if (this.armas == null){
            this.armas = new HashMap<>();
        }
        this.armas.put(arma.getNombre(), arma);
    }

    public void addArmadura(Armadura armadura) {
        if (this.armaduras == null){
            this.armaduras = new HashMap<>();
        }
        this.armaduras.put(armadura.getNombre(), armadura);
    }

//falta habilidad especial

}
