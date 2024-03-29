package mythossaga;

public class Desafio {
    private String desafiante;
    private String desafiado;
    private int apuesta;
    private boolean comprobado;
    private boolean terminado;

    public Desafio(String desafiante, String desafiado, int apuesta) {
        this.desafiante = desafiante;
        this.desafiado = desafiado;
        this.apuesta = apuesta;
        this.comprobado = false;
        this.terminado = false;
    }

    public String getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(String desafiante) {
        this.desafiante = desafiante;
    }

    public String getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(String desafiado) {
        this.desafiado = desafiado;
    }

    public int getApuesta() {
        return apuesta;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public boolean isComprobado() {
        return comprobado;
    }

    public void setComprobado(boolean comprobado) {
        this.comprobado = comprobado;
    }
}
