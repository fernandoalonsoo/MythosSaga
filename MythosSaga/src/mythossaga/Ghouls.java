package mythossaga;

public class Ghouls extends Esbirro{
    private Integer dependencia;

    public Ghouls(TypeEsbirro nombre, int salud, Integer dependencia) {
        super(nombre, salud);
        this.dependencia = dependencia;
    }

    public Integer getDependencia() {
        return dependencia;
    }

    public void setDependencia(Integer dependencia) {
        this.dependencia = dependencia;
    }
}
