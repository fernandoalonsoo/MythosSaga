
package mythossaga;

import mythossaga.*;
import mythossaga.GameManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

public class CombateTest {
    private Combate combate = new Combate(new Vampiro("Willy"), new Cazador("Nano"), 20, 17, new Date());
    private Database database;
    private Desafio desafio;
    private UsuarioJugador uDesafiante;
    private UsuarioJugador uDesafiado;

    @Test
    public void CombateTest() throws IOException, FileNotFoundException, ClassNotFoundException {
        GameManager gameManager = new GameManager();
        this.database = new Database();
        this.database.inicializarDatabase();

        //this.database = new Database();

        //this.uDesafiante = new Usuario("joe", "joe", "123");
        //this.uDesafiado = new Usuario("pol", "pol", "123");

        //database.añadirUsuario(uDesafiante);
        //database.añadirUsuario(uDesafiado);

        this.combate = new Combate(new Vampiro("Willy"), new Cazador("Nano"), 20, 17, new Date());
        ArrayList<Debilidad> debDesafiante = new ArrayList<Debilidad>();
        ArrayList<Fortaleza> fortDesafiante = new ArrayList<Fortaleza>();

        ArrayList<Debilidad> debDesafiado = new ArrayList<Debilidad>();
        ArrayList<Fortaleza> fortDesafiado = new ArrayList<Fortaleza>();

        this.desafio = new Desafio(new UsuarioJugador("Fer", "Fernando", "1234"), new UsuarioJugador("Guille", "Willy", "1234"), 20);
    }

    @Test
    public void calcularExitos() {
        combate.calcularExitos(5);
    }


    @Test
    public void testAceptarCombate() throws Exception {
        System.out.println("aceptarCombate");

        // Redirigir la salida estándar a un flujo de salida diferente
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Llamar al método que imprime por pantalla
        String entrada = "no";
        String input = String.join(System.lineSeparator(), entrada);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capturar la salida impresa
        String salidaPantalla = outputStream.toString();

        // Restaurar la salida estándar
        System.setOut(System.out);

        // Dividir las impresiones por línea
        String[] lineas = salidaPantalla.split(System.lineSeparator());

        // Obtener la última línea de impresión
        String ultimaLinea = lineas[lineas.length - 1];

    }

}
