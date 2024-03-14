/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mythossaga;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author guill
 */
class Sistema {
    public HashMap<String, User> usuarios;

    public Sistema(){
        usuarios = new HashMap<>();
    }

    Scanner scanner = new Scanner(System.in);

    public void menuInicio() throws IOException {
        int opcion = 0;
        while (opcion != 3) {
            System.out.println("Menu");
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
        scanner.close();
    }

    private void login() {
        System.out.print("Introduce el usuario: ");
        String usuario = scanner.next(); // Lee la entrada del usuario como una cadena
        System.out.println("Usuario introducido: " + usuario);
        System.out.print("Introduce la contraseña: ");
        String contrasena = scanner.next(); // Lee la entrada del usuario como una cadena
        System.out.println("Contraseña introducida: " + contrasena);
        
    }

    private void registro() {
        System.out.println("Introduce tu nombre de usuario: ");
        String usuario = scanner.next();
        //Comprobar si es posible ese usuario
        System.out.println("Introduce tu nick para el personaje: ");
        String nick = scanner.next();
        //Comprobar si es posible ese nick
        System.out.println("Introduce tu contraseña: ");
        String contrasena = scanner.next();
        User user = new UsuarioJugador(usuario, nick, contrasena);
        this.usuarios.put(usuario, user);
        menuUsuario();
        
    }

    private void menuUsuario() {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("Menu");
            System.out.println("Introduzca 1 para editar personaje");
            System.out.println("Introduzca 2 para gestionar desafios");
            System.out.println("Introduzca 3 para darse de baja");
            System.out.println("Introduzca 4 para cerrar sesión");
            opcion = scanner.nextInt();
        }
    }

}
