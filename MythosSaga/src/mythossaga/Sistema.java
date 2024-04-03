/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mythossaga;

import java.io.IOException;
import java.util.*;

class Sistema {
    public User userActivo;

    static transient Scanner scanner = new Scanner(System.in);

    public void menuInicio(Database database) throws IOException {
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("-----------------------");
            System.out.println("  MYTHOSSAGA ");
            System.out.println("-----------------------");
            System.out.println("Introduzca 1 para registrarse");
            System.out.println("Introduzca 2 para iniciar sesion");
            System.out.println("Introduzca 3 para salir del sistema");
            opcion = scanner.nextInt();
            if (opcion == 1) {
                registro(database);
            } else if (opcion == 2) {
                login(database);
            }
        }
        System.out.println("Hasta luego rey");
        scanner.close();
    }

    private void registro(Database data) {
        HashMap<String, User> usuarios = data.getUsuarios();
        System.out.println("Introduce tu nick de usuario: ");
        String nick = scanner.next();
        if(!usuarios.containsKey(nick)) {
            System.out.println("Introduce tu nickname de usuario: ");
            String usuario = scanner.next();
            System.out.println("Introduce tu contraseña: ");
            String contrasena = scanner.next();
            User user = new UsuarioJugador(usuario, nick, contrasena);
            usuarios.put(nick, user);
            this.userActivo = user;
            menuUsuario(data);
        } else {
            System.out.println("Ese nick de usuario ya esta cogido");
        }
    }

    private void login(Database data) {
        HashMap<String, User> usuarios = data.getUsuarios();
        System.out.print("Introduce el nick: ");
        String nick = scanner.next();
        System.out.print("Introduce la contraseña: ");
        String contrasena = scanner.next();
        if (usuarios.containsKey(nick) && usuarios.get(nick).getPassword().equals(contrasena)) { //puede que se pueda quitar la primera condicion del if
            System.out.println("Te has logeado correctamente en la aplicación");
            userActivo = usuarios.get(nick);
            if (userActivo instanceof UsuarioJugador){
                if(((UsuarioJugador) userActivo).isBloqueado()){
                    System.out.println("Se le ha bloqueado la entrada al sistema");
                } else {
                    menuUsuario(data);
                }
            } else {
                menuOperadores(data);
            }
        } else {
            System.out.println("Nombre de usuario o contraseña incorrecto");
        }
    }

    private void menuOperadores(Database data) {
        HashMap<String, User> usuarios = data.getUsuarios();
        ArrayList<Desafio> desafios = data.getDesafios();
        int opcion;

        do {
            System.out.println("\nMenu Operador");
            System.out.println("Introduzca 1 para editar personaje");
            System.out.println("Introduzca 2 para añadir items al personaje");
            System.out.println("Introduzca 3 para validar desafios");
            System.out.println("Introduzca 4 para bloquear usuarios");
            System.out.println("Introduzca 5 para desbloquear usuarios");
            System.out.println("Introduzca 6 para darse de baja");
            System.out.println("Introduzca 7 para salir");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Editando personaje");
                    editarPersonaje(usuarios);
                    break;
                case 2:
                    System.out.println("Añadiendo items");
                    anadirItems(usuarios);
                    break;
                case 3:
                    validarDesafios(desafios);
                    break;
                case 4:
                    System.out.println("Introduce el nick de un usuario que quieras bloquear");
                    String nombre = scanner.next();
                    if(usuarios.containsKey(nombre)){
                        User user = usuarios.get(nombre);
                        if(user instanceof UsuarioJugador){
                            ((UsuarioJugador) user).setBloqueado(true);
                            System.out.println("Usuario bloqueado");
                        } else {
                            System.out.println("No se puede bloquear a un operador");
                        }
                    } else {
                        System.out.println("No se encuentra a ese usuario");
                    }
                    break;
                case 5:
                    System.out.println("Usuarios bloqueados");
                    for(User u: usuarios.values()){
                        if(u instanceof UsuarioJugador){
                            if(((UsuarioJugador) u).isBloqueado()){
                                System.out.println(u.getNombre());
                            }
                        }
                    }
                    System.out.println("Introduce el nick de un usuario que quieras desbloquear");
                    String n = scanner.next();
                    if(usuarios.containsKey(n)){
                        User user = usuarios.get(n);
                        if(user instanceof UsuarioJugador){
                            ((UsuarioJugador) user).setBloqueado(false);
                            System.out.println("Usuario desbloqueado");
                        }
                    } else {
                        System.out.println("No se encuentra a ese usuario");
                    }
                    break;
                case 6:
                    System.out.println("Introduzca 'SI' si desea confirmar que se da de baja");
                    String confirmacion = scanner.next();
                    if(Objects.equals(confirmacion, "SI")){
                        System.out.println("Dándose de baja...");
                        System.out.println(userActivo.getNombre() + " ya no existe");
                        usuarios.remove(userActivo.getNick());
                        opcion = 5;
                    } else {System.out.println("No se ha dado de baja");}
                    break;
                case 7:
                    System.out.println("Cerrando sesion...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 7);
    }

    private void anadirItems(HashMap<String, User> usuarios) {
        System.out.print("Introduzca el nick del usuario al que deseas modificar su personaje: ");
        String nick = scanner.next();
        if (usuarios.containsKey(nick)) {
            User user = usuarios.get(nick);
            if (user instanceof UsuarioJugador) {
                System.out.println("Seleccione qué desea añadir al personaje:");
                System.out.println("1. Armas");
                System.out.println("2. Armaduras");
                System.out.println("3. Fortalezas");
                System.out.println("4. Debilidades");
                System.out.println("5. Esbirros");
                System.out.println("0. Salir");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 0:
                        System.out.println("Saliendo del menú...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
                        break;
                }
            }
        } else {
            System.out.println("No se encuentra a ese usuario");
        }
    }

    private void editarPersonaje(HashMap<String, User> usuarios) {
        System.out.print("Introduzca el nick del usuario al que deseas modificar su personaje: ");
        String nick = scanner.next();
        if(usuarios.containsKey(nick)){
            User user = usuarios.get(nick);
            if(user instanceof UsuarioJugador){
                Personaje personaje = ((UsuarioJugador) user).getPersonaje();
                System.out.println("Introduce los campos que deseas modificar, sino pulse enter");
                System.out.println("Oro actual " + personaje.getOro() + ", nuevo oro: ");
                if (scanner.hasNextInt()) {
                    int nuevoOro = scanner.nextInt();
                    personaje.setOro(nuevoOro);
                    System.out.println("Oro cambiado correctamente");
                } else {
                    scanner.next(); // Consumir la entrada incorrecta (no es un entero)
                    System.out.println("No has introducido un número válido.");
                }
                System.out.println("Salud actual " + personaje.getSalud() + ", nueva salud: ");
                if (scanner.hasNextInt()) {
                    int nuevaSalud = scanner.nextInt();
                    personaje.setSalud(nuevaSalud);
                    System.out.println("Salud cambiada correctamente");
                } else {
                    scanner.next(); // Consumir la entrada incorrecta (no es un entero)
                    System.out.println("No has introducido un número válido.");
                }
                System.out.println("Poder actual " + personaje.getPoder() + ", nuevo poder: ");
                if (scanner.hasNextInt()) {
                    int nuevoPoder = scanner.nextInt();
                    personaje.setPoder(nuevoPoder);
                    System.out.println("Poder cambiado correctamente");
                } else {
                    scanner.next(); // Consumir la entrada incorrecta (no es un entero)
                    System.out.println("No has introducido un número válido.");
                }
                System.out.println("Armadura actual " + personaje.getArmaduraActiva() + ", nueva armadura: ");
                String acarreo = scanner.nextLine();
                String input = scanner.nextLine();
                if (!input.isEmpty()) {
                    try {
                        if(personaje.getArmaduras().containsKey(input)){
                            personaje.setArmaduraActiva(personaje.getArmaduras().get(input));
                            System.out.println("Armadura cambiada correctamente");
                        } else{
                            System.out.println("El personaje no tiene esa armadura");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada no válida. Por favor, introduce un número.");
                    }
                } else {
                    System.out.println("No has introducido ningún valor. Se mantendrá la armadura actual.");
                }
                //Falta el arma
            }
        } else {
            System.out.println("No se encuentra a ese usuario");
        }
    }

    private static void validarDesafios(ArrayList<Desafio> desafios) {
        boolean desafioValidable = false;
        for(Desafio d: desafios){
            if(!d.isComprobado()){
                desafioValidable = true;
                System.out.println("Desafiante: " + d.getDesafiante());
                System.out.println("Desafiado: " + d.getDesafiado());
                System.out.println("Oro apostado: " + d.getApuesta());
            }
            System.out.println("Si quieres validar introduce 'VALIDAR'");
            if(scanner.next().equals("VALIDAR")){
                d.setComprobado(true);
                System.out.println("Desafio validado");
            }
        }
        if(!desafioValidable){System.out.println("No hay desafios por validar");}
    }

    private void menuUsuario(Database data) {
        HashMap<String, User> usuarios = data.getUsuarios();
        ArrayList<Desafio> desafios = data.getDesafios();
        int opcion;
        for(Desafio desafio: desafios){
            if(desafio.isComprobado() && Objects.equals(desafio.getDesafiado(), userActivo.getNick())){
                System.out.println("Tienes un desafio pendiente de " + desafio.getDesafiante());
                System.out.println("Si desea aceptarlo escriba 1, escriba cualquier otra cosa si desea rechazarlo");
                String accept = scanner.next();
                if(Objects.equals(accept, "1")){
                    //Se lleva acabo el combate
                } else{
                    desafio.setTerminado(true);
                    double oro = 0.1 * desafio.getApuesta();
                    UsuarioJugador desafiante = (UsuarioJugador) usuarios.get(desafio.getDesafiante());
                    desafiante.actualizarOro(oro);
                    UsuarioJugador desafiado = (UsuarioJugador) usuarios.get(desafio.getDesafiado());
                    desafiado.actualizarOro(-oro);
                }
            }
        }
        do {
            System.out.println("\nMenu");
            System.out.println("Introduzca 1 para gestionar personaje");
            System.out.println("Introduzca 2 para gestionar desafios");
            System.out.println("Introduzca 3 para consultar estadísticas");
            System.out.println("Introduzca 4 para darse de baja");
            System.out.println("Introduzca 5 para cerrar sesión");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Gestionando personaje...");
                    userActivo.menuGestionarPersonajes(scanner);
                    break;
                case 2:
                    System.out.println("Gestionando desafíos...");
                    if (userActivo.comprobarPersonajes()){
                        gestionarDesafios(data);
                    } else {
                        System.out.println("No hay personajes creados, no se puede desafiar");
                    }
                    break;
                case 3:
                    System.out.println("Consultando estadísticas...");
                    break;
                case 4:
                    System.out.println("Introduzca 'SI' si desea confirmar que se da de baja");
                    String confirmacion = scanner.next();
                    if(Objects.equals(confirmacion, "SI")){
                        System.out.println("Dándose de baja...");
                        System.out.println(userActivo.getNombre() + " ya no existe");
                        usuarios.remove(userActivo.getNick());
                        opcion = 5;
                    } else {System.out.println("No se ha dado de baja");}
                    break;
                case 5:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);
    }

    private void gestionarDesafios(Database data) {
        HashMap<String, User> usuarios = data.getUsuarios();
        System.out.println("DESAFIO\nIntroduzca el nombre del usuario a desafiar");
        String desafiado = scanner.next();
        if (usuarios.containsKey(desafiado)){
            while(true) {
                System.out.println("Introduzca la cantidad de oro a apostar");
                int oro_apostado = scanner.nextInt();
                if (oro_apostado > 0 && usuarios.get(desafiado).oroSuficiente(oro_apostado)){
                    data.crearDesafio(userActivo.getNick(), desafiado, oro_apostado);
                    System.out.println("Desafio creado");
                    break;
                } else {
                    System.out.println("No puedes apostar esa cantidad de oro");
                }
            }
        } else {
            System.out.println("No se ha encontrado a ningun jugador con ese nick");
        }

    }

}
