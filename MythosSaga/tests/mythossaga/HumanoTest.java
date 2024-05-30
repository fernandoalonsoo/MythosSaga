package mythossaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HumanoTest {

    private Humano humano;

    @Before
    public void setUp() {
        humano = new Humano(TypeEsbirro.humano, 100, Lealtad.ALTO);
    }

    @Test
    public void testHumanoConstructor() {
        assertEquals(TypeEsbirro.humano, humano.getNombre());
        assertEquals(100, humano.getSalud());
        assertEquals(Lealtad.ALTO, humano.getLealtad());
    }

    @Test
    public void testGetLealtad() {
        assertEquals(Lealtad.ALTO, humano.getLealtad());
    }

    @Test
    public void testSetLealtad() {
        humano.setLealtad(Lealtad.BAJO);
        assertEquals(Lealtad.BAJO, humano.getLealtad());
    }

    @Test
    public void testSetNombre() { // No deberia de dejar
        humano.setNombre(TypeEsbirro.ghoul);
        assertEquals(TypeEsbirro.ghoul, humano.getNombre());
    }

    @Test
    public void testSetSalud() {
        humano.setSalud(150);
        assertEquals(150, humano.getSalud());
    }
}
