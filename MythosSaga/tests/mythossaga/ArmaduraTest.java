package mythossaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArmaduraTest {

    private Armadura armadura;

    @Before
    public void setUp() {
        armadura = new Armadura("Cota de malla", 15);
    }

    @Test
    public void testArmaduraConstructor() {
        assertEquals("Cota de malla", armadura.getNombre());
        assertEquals(15, armadura.getModificador());
    }

    @Test
    public void testGetValorAtaque() {
        assertEquals(0, armadura.getValorAtaque());
    }

    @Test
    public void testGetValorDefensa() {
        assertEquals(15, armadura.getValorDefensa());
    }

    @Test
    public void testToString() {
        String expected = "Nombre: Cota de malla, Modificador de defensa: 15";
        assertEquals(expected, armadura.toString());
    }
}
