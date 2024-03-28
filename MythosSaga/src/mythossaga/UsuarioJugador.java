package mythossaga;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;

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
        System.out.println("Ingrese el nomber del personaje a borrar");
    }

    public void gestionarEquipo() {
        Scanner scanner = new Scanner (System.in);
        ArrayList<Equipo> equipo = new ArrayList<>();

        int option;

        do {
            System.out.println("\nMENU GESTION EQUIPO");
            System.out.println("1. Agregar arma");
            System.out.println("2. Agregar armadura");
            System.out.println("3. Cambiar arma activa");
            System.out.println("4. Ver equipo actual");
            System.out.println("5. Volver al menú anterior");
            option = scanner.nextInt();

        switch (option) {
            case 1:
                agregarArma(scanner, equipo);
                break;
            case 2:
                agregarArmadura(scanner, equipo);
                break;
            case 3:
                cambiarArmaActiva(scanner, equipo);
                break;
            case 4:
                mostrarEquipo(equipo);
                break;
            case 5:
                System.out.println("Volviendo al menú anterior...");
                break;
            default:
                System.out.println("Opción no válida");
        }
        } while (option != 5);
    }

    private void agregarArma(Scanner scanner, ArrayList<Equipo> equipo) {
        int manosOcupadas = 0;
        for (Equipo item : equipo) {
            if (item instanceof Arma arma) {
                manosOcupadas += arma.getManos();
            }
        }
        if (manosOcupadas >= 2) {
            System.out.println("El personaje ya tiene armas ocupando ambas manos. No puede agregar más.");
            return;
        }
        System.out.println("Ingrese el nombre del arma:");
        String nombre = scanner.next();
        System.out.println("Ingrese el modificador de ataque de este arma:");
        int modificador = scanner.nextInt();
        System.out.println("Ingrese el número de manos que requiere este arma (1 o 2)");
        int manos = scanner.nextInt();
        if (manosOcupadas + manos > 2) {
            System.out.println("El personaje no tiene suficiente espacio para esta arma. No puede agregarla.");
            return;
        }
        Arma arma = new Arma(nombre, modificador, manos);
        equipo.add(arma);
    }

    private void cambiarArmaActiva(Scanner scanner, ArrayList<Equipo> equipo) {

    }
    private void mostrarEquipo(ArrayList<Equipo> equipo) {
        ArrayList<Arma> armas = new ArrayList<>();
        ArrayList<Armadura> armaduras = new ArrayList<>();

        for (Equipo item : equipo) {
            if (item instanceof Arma) {
                armas.add((Arma) item);
            } else if (item instanceof Armadura) {
                armaduras.add((Armadura) item);
            }
        }

        System.out.println("\nArmas:");
        for (Arma arma : armas) {
            System.out.println("Nombre: " + arma.getNombre() + ", Modificador de ataque: " + arma.getModificador()+",Manos ocupadas: "+arma.getManos());
        }

        System.out.println("\nArmaduras:");
        for (Armadura armadura : armaduras) {
            System.out.println("Nombre: " + armadura.getNombre() + ", Modificador de defensa: " + armadura.getModificador());
        }
    }


    private void agregarArmadura(Scanner scanner, ArrayList<Equipo> equipo) {
        System.out.println("Ingrese el nombre de la armadura:");
        String nombre = scanner.next();
        System.out.println("Ingrese el modificador de defensa de la armadura:");
        int modificadorDefensa = scanner.nextInt();
        Armadura armadura = new Armadura(nombre, modificadorDefensa);
        equipo.add(armadura);
    }

}
