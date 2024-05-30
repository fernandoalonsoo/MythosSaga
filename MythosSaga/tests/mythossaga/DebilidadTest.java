package mythossaga;

import org.junit.Test;
import static org.junit.Assert.*;

public class DebilidadTest {

    @Test
    public void testDebilidadConstructor() {
        String nombre = "Fuego";
        int valor = 10;
        Debilidad debilidad = new Debilidad(nombre, valor);

        assertEquals(nombre, debilidad.getNombre());
        assertEquals(valor, debilidad.getValor());
    }

    @Test
    public void testSetNombre() {
        Debilidad debilidad = new Debilidad("Fuego", 10);
        debilidad.setNombre("Agua");
        assertEquals("Agua", debilidad.getNombre());
    }

    @Test
    public void testSetValor() {
        Debilidad debilidad = new Debilidad("Fuego", 10);
        debilidad.setValor(20);
        assertEquals(20, debilidad.getValor());
    }
}
