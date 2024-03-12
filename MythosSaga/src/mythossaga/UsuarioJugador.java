package mythossaga;

import java.util.concurrent.atomic.AtomicInteger;

public class UsuarioJugador extends User {
    private static final AtomicInteger contadorRegistros = new AtomicInteger(0);
    private final String numeroRegistro;

    // Constructor
    public UsuarioJugador(String nombre, String nick, String password) {
        super(nombre, nick, password);
        this.numeroRegistro = generarNumeroRegistro();
    }

    private String generarNumeroRegistro() {
        int numero = contadorRegistros.incrementAndGet();
        int digitoUnidad = numero % 10; // Último dígito del número
        int digitoDecena = (numero / 10) % 10; // Dígito de las decenas del número
        char letra = (char) ('A' + (digitoUnidad - 1)); // Convierte el dígito en una letra (A=1, B=2, etc.)
        return "L" + digitoDecena + digitoUnidad + letra + letra;
    }
}