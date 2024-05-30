package mythossaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArmaTest {

    private Arma arma;

    @Before
    public void setUp() {
        arma = new Arma("Espada", 10, 1);
    }

    @Test
    public void testArmaConstructor() {
        assertEquals("Espada", arma.getNombre());
        assertEquals(10, arma.getModificador());
        assertEquals(1, arma.getManos());
    }

    @Test
    public void testGetValorAtaque() {
        assertEquals(10, arma.getValorAtaque());
    }

    @Test
    public void testGetValorDefensa() {
        assertEquals(0, arma.getValorDefensa());
    }

    @Test
    public void testToString() {
        String expected = "Nombre: Espada, Modificador de ataque: 10, Manos ocupadas: 1";
        assertEquals(expected, arma.toString());
    }
}
