/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mythossaga;

import java.io.IOException;
import java.util.*;

class Sistema {
    public User userActivo;

    transient Scanner scanner = new Scanner(System.in);

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
                menuUsuario(data);
            } else {
                menuOperadores();
            }
        } else {
            System.out.println("Nombre de usuario o contraseña incorrecto");
        }
    }

    private void menuOperadores() {

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
                    if (userActivo.comprobarPersonajes()){
                        gestionarDesafios(data);
                        System.out.println("Gestionando desafíos...");
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
