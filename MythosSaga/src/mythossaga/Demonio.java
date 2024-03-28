package mythossaga;

import java.util.ArrayList;

public class Demonio extends Esbirro{

    private ArrayList<Esbirro> esbirros;
    private String pacto;

    public Demonio(TypeEsbirro nombre, int salud, ArrayList<Esbirro> esbirros, String pacto) {
        super(nombre, salud);
        this.esbirros = esbirros;
        this.pacto = pacto;
    }

    public ArrayList<Esbirro> getEsbirros() {
        return esbirros;
    }

    public String getPacto() {
        return pacto;
    }

    public void setEsbirros(ArrayList<Esbirro> esbirros) {
        this.esbirros = esbirros;
    }

    public void setPacto(String pacto) {
        this.pacto = pacto;
    }
}
