package mythossaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FortalezaTest {

    private Fortaleza fortaleza;

    @Before
    public void setUp() {
        fortaleza = new Fortaleza("Resistencia", 20);
    }

    @Test
    public void testFortalezaConstructor() {
        assertEquals("Resistencia", fortaleza.getNombre());
        assertEquals(20, fortaleza.getValor());
    }

    @Test
    public void testSetNombre() {
        fortaleza.setNombre("Inmunidad");
        assertEquals("Inmunidad", fortaleza.getNombre());
    }

    @Test
    public void testSetValor() {
        fortaleza.setValor(25);
        assertEquals(25, fortaleza.getValor());
    }
}
