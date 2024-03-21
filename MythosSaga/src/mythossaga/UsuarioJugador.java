package mythossaga;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class UsuarioJugador extends User {
    private static final AtomicInteger contadorRegistros = new AtomicInteger(0);
    private HashMap<String, Personaje> personajes;

    // Constructor
    public UsuarioJugador(String nombre, String nick, String password) {
        super(nombre, nick, password);
        String numeroRegistro = generarNumeroRegistro();
    }

    private String generarNumeroRegistro() {
        int numero = contadorRegistros.incrementAndGet();
        int digitoUnidad = numero % 10; // Último dígito del número
        int digitoDecena = (numero / 10) % 10; // Dígito de las decenas del número
        char letra = (char) ('A' + (digitoUnidad - 1)); // Convierte el dígito en una letra (A=1, B=2, etc.)
        return "L" + digitoDecena + digitoUnidad + letra + letra;
    }

    @Override
    public void menuGestionarPersonajes(Scanner scanner) {
        int opcion;

        do {
            System.out.println("\nMENU GESTION PERSONAJE");
            System.out.println("1. Registrar personaje");
            System.out.println("2. Dar de baja personaje");
            System.out.println("3. Gestion armas y armaduras");
            System.out.println("4. Salir del menu");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1: registroPersonaje(scanner);
                case 2: darBajaPersonaje();
                case 3: gestionarEquipo();
                case 4:
                    System.out.println("Cerrando menu gestion de personajes");
                    break;
                default: System.out.println("Opcion no válida");
            }
        } while (opcion != 4);
    }

    public void registroPersonaje(Scanner scanner) {
        System.out.println("Ingrese el nombre del personaje:");
        String nombre = scanner.next();

        System.out.println("Ingrese la salud del personaje:");
        int salud = scanner.nextInt();
        scanner.nextLine();

        // Continuar con el resto de los atributos...
    }

    public void darBajaPersonaje() {
    }

    public void gestionarEquipo() {
    }
}