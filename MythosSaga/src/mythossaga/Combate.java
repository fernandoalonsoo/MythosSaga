package mythossaga;
import java.util.Date;
import java.util.Random;

public class Combate {
    private final Personaje desafiante;
    private final Personaje desafiado;
    private int saludDesafiante;
    private int saludDesafiado;
    private int round;
    private Personaje vencedor;
    private int oroGanado;

    public Combate(Personaje desafiante, Personaje desafiado, int saludDesafiante, int saludDesafiado, Date fecha) {
        this.desafiante = desafiante;
        this.desafiado = desafiado;
        this.saludDesafiante = saludDesafiante;
        this.saludDesafiado = saludDesafiado;
        this.round = 0;
        this.vencedor = null;
        this.oroGanado = 0;
    }

    public void setModificadores(Desafio desafio) {

    }

    public void jugarRonda(Desafio desafio) {
        this.round++;

        System.out.println("Ronda " + this.round + ":");

        int potencialAtaqueDesafiante = calcularPotencialAtaque(desafiante);
        int potencialAtaqueDesafiado = calcularPotencialAtaque(desafiado);
        int potencialDefensaDesafiante = calcularPotencialDefensa(desafiante);
        int potencialDefensaDesafiado = calcularPotencialDefensa(desafiado);

        System.out.println("Potencial de ataque del desafiante: " + potencialAtaqueDesafiante);
        System.out.println("Potencial de ataque del desafiado: " + potencialAtaqueDesafiado);
        System.out.println("Potencial de defensa del desafiante: " + potencialDefensaDesafiante);
        System.out.println("Potencial de defensa del desafiado: " + potencialDefensaDesafiado);

        int exitosAtaqueDesafiante = calcularExitos(potencialAtaqueDesafiante);
        int exitosAtaqueDesafiado = calcularExitos(potencialAtaqueDesafiado);
        int exitosDefensaDesafiante = calcularExitos(potencialDefensaDesafiante);
        int exitosDefensaDesafiado = calcularExitos(potencialDefensaDesafiado);

        System.out.println("Éxitos de ataque del desafiante: " + exitosAtaqueDesafiante);
        System.out.println("Éxitos de ataque del desafiado: " + exitosAtaqueDesafiado);
        System.out.println("Éxitos de defensa del desafiante: " + exitosDefensaDesafiante);
        System.out.println("Éxitos de defensa del desafiado: " + exitosDefensaDesafiado);

        int danoDesafiante = Math.max(0, exitosAtaqueDesafiante - exitosDefensaDesafiado);
        int danoDesafiado = Math.max(0, exitosAtaqueDesafiado - exitosDefensaDesafiante);

        System.out.println("Daño causado por el desafiante: " + danoDesafiante);
        System.out.println("Daño causado por el desafiado: " + danoDesafiado);


        this.saludDesafiante -= danoDesafiante;
        this.saludDesafiado -= danoDesafiado;

        System.out.println("Salud del desafiante actualizada tras la ronda : " + this.saludDesafiante);
        System.out.println("Salud del desafiado actualizada tras la ronda: " + this.saludDesafiado);

        if (this.saludDesafiante <= 0 || this.saludDesafiado <= 0) {
            terminarCombate();
            desafio.setTerminado(true);
        }


    }

    private int calcularPotencialAtaque(Personaje personaje) {
        int potencialAtaque = personaje.getPoder(); // Primero el potencial de ataque es el poder del personaje (común)

        switch (personaje) {
            case Vampiro vampiro -> {

                potencialAtaque += vampiro.getValorAtaqueDisciplina(); // Sumar el valor de ataque de la disciplina

                potencialAtaque += vampiro.getValorAtaqueEquipoActivo(); // Sumar el valor de ataque del equipo activo

                if (vampiro.getPuntosSangre() >= 5) { // Si el valor de sangre es mayor o igual a 5
                    potencialAtaque += 2; // Sumar 2 al potencial de ataque
                }
            }
            case Licantropo licantropo -> {
                potencialAtaque += licantropo.getValorAtaqueDon(); // Sumar el valor de ataque del don (condición implementada en el metodo)

                potencialAtaque += licantropo.getValorAtaqueEquipoActivo(); // Sumar el valor de ataque del equipo activo

                potencialAtaque += licantropo.getRabia(); // Sumar la rabia actual  // Si el personaje es un licántropo
            }
            case Cazador cazador -> {
                potencialAtaque += cazador.getValorAtaqueEquipoActivo(); // Sumar el valor de ataque del equipo activo

                potencialAtaque += cazador.getVoluntadActual(); // Sumar la voluntad actual  // Si el personaje es un cazador
            }
            default -> {
            }
        }

        return potencialAtaque;
    }


    private int calcularExitos(int potencial) {

        int exitos = 0;
        Random random = new Random();
        for (int i = 0; i < potencial; i++) {
            if (random.nextInt(6) + 1 >= 5) {
                exitos++;
            }
        }
        return exitos;
    }

    private void terminarCombate() {
        if (this.saludDesafiante <= 0 && this.saludDesafiado <= 0) {
            System.out.println("El combate ha terminado en empate.");
        } else if (this.saludDesafiante <= 0) {
            this.vencedor = this.desafiado;
            System.out.println("El combate ha terminado. El vencedor es " + this.vencedor.getNombre() + ".");
        } else {
            this.vencedor = this.desafiante;
            System.out.println("El combate ha terminado. El vencedor es " + this.vencedor.getNombre() + ".");
        }

    }

    private int calcularPotencialDefensa(Personaje personaje) {
        int potencialDefensa = personaje.getPoder(); // Inicialmente, el potencial de defensa es el poder del personaje

        switch (personaje) {
            case Vampiro vampiro -> {
                potencialDefensa += vampiro.getValorDefensaDisciplina(); // Sumar el valor de defensa de la disciplina

                potencialDefensa += vampiro.getValorDefensaEquipoActivo(); // Sumar el valor de defensa del equipo activo  // Si el personaje es un vampiro
            }
            case Licantropo licantropo -> {
                potencialDefensa += licantropo.getValorDefensaDon(); // Sumar el valor de defensa del don

                potencialDefensa += licantropo.getValorDefensaEquipoActivo(); // Sumar el valor de defensa del equipo activo  // Si el personaje es un licántropo
            }
            case Cazador cazador -> {
                potencialDefensa+= cazador.getVoluntadActual(); // Sumar la voluntad actual  // Si el personaje es un cazador


                potencialDefensa += cazador.getValorDefensaEquipoActivo(); // Sumar el valor de defensa del equipo activo  // Si el personaje es un cazador
            }
            default -> {
            }
        }
        return potencialDefensa;
    }


}
