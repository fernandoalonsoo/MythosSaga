/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mythossaga;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author guill
 */
class Sistema {

    Scanner scanner = new Scanner(System.in);
    
    public void menuInicio() throws IOException {
        System.out.println("Menu");
        System.out.println("Introduzca 1 para registrarse");
        System.out.println("Introduzca 2 para iniciar sesion");
        int opcion = scanner.nextInt();
        if (opcion == 1){
            System.out.println("chao");
        } else if (opcion == 2){
            System.out.print("Introduce el usuario: ");
            String usuario = scanner.next(); // Lee la entrada del usuario como una cadena
            System.out.println("Usuario introducido: " + usuario);
            System.out.print("Introduce la contraseña: ");
            String contraseña = scanner.next(); // Lee la entrada del usuario como una cadena
            System.out.println("Contraseña introducida: " + contraseña);
            scanner.close();
        } 
    }
    
}
