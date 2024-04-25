package test;

import mythossaga.Arma;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmaTest {

    @Test
    public void testGetManos() {
        Arma arma = new Arma("Espada", 5, 1);
        int manos = arma.getManos();
        assertEquals(1, manos, "El número de manos ocupadas debe ser 1");
    }

    @Test
    public void testToString() {
        Arma arma = new Arma("Espada", 5, 1);
        String resultado = arma.toString();
        assertEquals("Nombre: Espada, Modificador de ataque: 5, Manos ocupadas: 1", resultado,
                "El método toString() debe devolver una cadena formateada correctamente");
    }

    @Test
    public void testGetValorAtaque() {
        Arma arma = new Arma("Espada", 5, 1);
        int valorAtaque = arma.getValorAtaque();
        assertEquals(5, valorAtaque, "El valor de ataque debe ser igual al modificador de la arma");
    }


}
