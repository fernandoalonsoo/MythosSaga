/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mythossaga;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author guill
 */
class Sistema {
    public HashMap<String, User> usuarios;
    public User userActivo;

    public Sistema(){
        usuarios = new HashMap<>();
    }

    Scanner scanner = new Scanner(System.in);

    public void menuInicio() throws IOException {
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
                registro();
            } else if (opcion == 2) {
                login();
            }
        }
        System.out.println("Hasta luego rey");
        scanner.close();
    }

    private void login() {
        System.out.print("Introduce el usuario: ");
        String usuario = scanner.next();
        System.out.print("Introduce la contraseña: ");
        String contrasena = scanner.next();
        if (usuarios.containsKey(usuario) && usuarios.get(usuario).getPassword().equals(contrasena)) { //puede que se pueda quitar la primera condicion del if
            System.out.println("Te has logeado correctamente en la aplicación");
            userActivo = usuarios.get(usuario);
            if (userActivo instanceof UsuarioJugador){
                menuUsuario();
            }
        } else {
            System.out.println("Nombre de usuario o contraseña incorrecto");
        }
    }

    private void registro() {
        System.out.println("Introduce tu nombre de usuario: ");
        String usuario = scanner.next();
        if(!usuarios.containsKey(usuario)) {
            System.out.println("Introduce tu nick para el personaje: ");
            String nick = scanner.next();
            //Comprobar si es posible ese nick
            System.out.println("Introduce tu contraseña: ");
            String contrasena = scanner.next();
            User user = new UsuarioJugador(usuario, nick, contrasena);
            this.usuarios.put(usuario, user);
            this.userActivo = user;
            menuUsuario();
        } else {
            System.out.println("Ese nombre de usuario ya esta cogido");
        }
    }

    private void menuUsuario() {
        int opcion;
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

}
