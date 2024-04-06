package mythossaga;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class UsuarioJugador extends User implements Serializable {
    private static final AtomicInteger contadorRegistros = new AtomicInteger(0);
    private Personaje personaje;
    private boolean bloqueado;
    private String numeroRegistro;
    private transient Scanner scan;

    // Constructor
    public UsuarioJugador(String nombre, String nick, String password) {
        super(nombre, nick, password);
        String numeroRegistro = generarNumeroRegistro();
        this.numeroRegistro = numeroRegistro;
        this.bloqueado = false;
    }


    private String generarNumeroRegistro() {
        int numero = contadorRegistros.incrementAndGet();
        int digitoUnidad = numero % 10; // Último dígito del número
        int digitoDecena = (numero / 10) % 10; // Dígito de las decenas del número
        char letra = (char) ('A' + (digitoUnidad - 1)); // Convierte el dígito en una letra (A=1, B=2, etc.)
        return "L" + digitoDecena + digitoUnidad + letra + letra;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    @Override
    public void menuGestionarPersonajes(Scanner scanner) {
        int opcion;
        this.scan = scanner;
        do {
            System.out.println("\nMENU GESTION PERSONAJE");
            if (personaje != null){
                System.out.println("1. Dar de baja personaje");
                System.out.println("2. Gestion armas y armaduras");
                System.out.println("3. Salir del menu");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        darBajaPersonaje();
                        break;
                    case 2:
                        gestionarEquipo();
                        break;
                    case 3:
                        System.out.println("Cerrando menu gestion de personajes");
                        break;
                    default: System.out.println("Opcion no válida");
                }
            } else {
                System.out.println("1. Registrar personaje");
                System.out.println("3. Salir del menu");
                opcion = scanner.nextInt();
                switch (opcion){
                    case 1:
                        registroPersonaje();
                        break;
                    case 3:
                        System.out.println("Cerrando menu gestion de personajes");
                        break;
                    default: System.out.println("Opcion no válida");
                }
            }
        } while (opcion != 3);
    }

    public void registroPersonaje() {
        Scanner input = new Scanner(System.in);
        int salud;
        int poder;

        System.out.println("Ingrese el nombre del personaje:");
        String nombre = scan.next();
        System.out.println("Elija una opcion:");
        System.out.println("1.- Seleccionar vampiro");
        System.out.println("2.- Seleccionar licantropo");
        System.out.println("3.- Seleccionar cazador");
        int opcion = input.nextInt();

        System.out.println("Ingrese el poder y la salud, la suma entre los valores no puede ser mayor que 7");
        do {
            System.out.println("Salud:");
            salud = scan.nextInt();
            System.out.println("Poder:");
            poder = scan.nextInt();
            if(salud + poder > 7){
                System.out.println("Valores incorrectos, recuerde, salud + poder no mayor a 7");
            }
        } while (salud + poder > 7);

        switch (opcion){
            case 1: input.nextLine();
                this.personaje = new Vampiro(nombre);
                break;

            case 2: input.nextLine();
                this.personaje = new Licantropo(nombre);
                break;

            case 3: input.nextLine();
                this.personaje = new Cazador(nombre);
                break;

            case 4: break;

            default:System.out.println("\n--- Por favor seleccione una opcion correcta ---\n");
                break;
        }
    }


    public void crearPersonaje(Personaje personaje){
        this.personaje = personaje;
    }

    public void darBajaPersonaje() {
        System.out.println("Ingrese 'ELIMINAR' si quiere eliminar su personaje definitivamente");
        String confirmacion = scan.next();
        if(Objects.equals(confirmacion, "ELIMINAR")){
            System.out.println("Dando de baja al personaje...");
            personaje = null;
        } else {System.out.println("No se ha dado de baja");}
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
                agregarArma(scanner, equipo, personaje);
                break;
            case 2:
                agregarArmadura(scanner, equipo, personaje);
                break;
            case 3:
                cambiarArmaActiva(scanner, equipo);
                break;
            case 4:
                mostrarEquipo(equipo, personaje);
                break;
            case 5:
                System.out.println("Volviendo al menú anterior...");
                break;
            default:
                System.out.println("Opción no válida");
        }
        } while (option != 5);
    }

    private void agregarArma(Scanner scanner, ArrayList<Equipo> equipo, Personaje personaje) {
        int manosOcupadas = 0;
        for (Equipo item : equipo) {
            if (item instanceof Arma arma) {
                manosOcupadas += arma.getManos();
            }
        }
        if (manosOcupadas >= 2) {
            System.out.println("El personaje ya tiene armas ocupando ambas manos. No puede agregar más.");
            return;
        } else {
            System.out.println("Ingrese el nombre del arma:");
            String nombre = scanner.next();
            System.out.println("Ingrese el modificador de ataque de este arma:");
            int modificador = scanner.nextInt();
            System.out.println("Ingrese el número de manos que requiere este arma (1 o 2)");
            int manos = scanner.nextInt();
            if (manosOcupadas + manos > 2) {
                System.out.println("El personaje no tiene suficiente espacio para esta arma. No puede agregarla.");
                return;
            } else {
                Arma arma = new Arma(nombre, modificador, manos);
                equipo.add(arma);
                personaje.addArmas(arma);
            }
        }

    }

    private void cambiarArmaActiva(Scanner scanner, ArrayList<Equipo> equipo) {
        HashMap<String, Equipo> armas = personaje.getArmas();
        System.out.println("Estas son las armas de las que dispones");
        for (Equipo arma : armas.values()) {
            System.out.println(arma);
        }


        boolean added = false;
        System.out.println("Escoja la nueva arma de la que disponer");
        while (!added) {
            String armaNombre = scan.next();
            if (armas.containsKey(armaNombre)){
                Equipo arma = armas.get(armaNombre);
                Arma armaInstancia = (Arma) arma;
                System.out.println("Ya esta añadida");
                added = true;
                if (armaInstancia.getManos() == 2) {
                    personaje.setArmaActiva(arma);
                } else {
                    System.out.println("Puede añadir una mas que sea unicamente de una mano");
                    String armaNombre2 = scan.next();
                    if (armas.containsKey(armaNombre)){
                        Equipo arma2 = armas.get(armaNombre);
                        Arma armaInstancia2 = (Arma) arma;
                        if (armaInstancia2.getManos() == 1){
                           System.out.println("Añadidas ambas armas");
                        } else {
                            System.out.println("No se puede añadir ese arma ya que es de mas de 1 mano");
                        }
                    } else {
                        System.out.println("No existe ese arma, te quedas con solo una en una mano");
                    }
                }
            } else {
                System.out.println("Escriba el nombre correctamente");
            }
        }
    }
    private void mostrarEquipo(ArrayList<Equipo> equipo, Personaje personaje) {
        HashMap<String, Equipo> armas = personaje.getArmas();
        HashMap<String, Equipo> armaduras = personaje.getArmaduras();
        System.out.println(personaje.getNombre());

        if(armas.isEmpty()){
            System.out.println("No tienes armas");
        } else {
            System.out.println("\nArmas:");
            Collection<Equipo> listArmas = armas.values();
            for (Equipo arma : listArmas) {
                System.out.println(arma);
            }
        }

        if(armaduras.isEmpty()){
            System.out.println("No tienes armaduras");
        } else {
            System.out.println("\nArmas:");
            Collection<Equipo> listArmaduras = armaduras.values();
            for (Equipo armadura : listArmaduras) {
                System.out.println(armadura);
            }
        }
    }

    private void agregarArmadura(Scanner scanner, ArrayList<Equipo> equipo, Personaje personaje) {
        System.out.println("Ingrese el nombre de la armadura:");
        String nombre = scanner.next();
        System.out.println("Ingrese el modificador de defensa de la armadura:");
        int modificadorDefensa = scanner.nextInt();
        Armadura armadura = new Armadura(nombre, modificadorDefensa);
        personaje.addArmadura(armadura);
        equipo.add(armadura);
    }

    @Override
    public boolean comprobarPersonajes(){
        return personaje != null;
    }

    @Override
    public boolean oroSuficiente(int oro){
        return oro < personaje.getOro();
    }
    public void actualizarOro(double oro){
        double newOro = personaje.getOro();
        newOro = newOro + oro;
        personaje.setOro(newOro);
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Personaje getPersonaje() {
        return personaje;
    }
}
