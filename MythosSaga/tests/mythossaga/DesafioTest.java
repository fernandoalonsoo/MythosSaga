package mythossaga;

import mythossaga.Desafio;
import mythossaga.UsuarioJugador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DesafioTest {

    @Test
    public void testConstructorAndGetters() {

        UsuarioJugador desafiante = new UsuarioJugador("Juan", "juan123", "password");
        UsuarioJugador desafiado = new UsuarioJugador("Pedro", "pedro456", "password");
        int apuesta = 50;

        Desafio desafio = new Desafio(desafiante, desafiado, apuesta);

        assertEquals(desafiante, desafio.getDesafiante(), "El desafiante no coincide con el valor esperado");
        assertEquals(desafiado, desafio.getDesafiado(), "El desafiado no coincide con el valor esperado");
        assertEquals(apuesta, desafio.getApuesta(), "La apuesta no coincide con el valor esperado");
        assertFalse(desafio.isTerminado(), "El desafío no debería estar terminado por defecto");
        assertFalse(desafio.isComprobado(), "El desafío no debería estar comprobado por defecto");
    }

    @Test
    public void testSetters() {

        UsuarioJugador desafiante = new UsuarioJugador("Juan", "juan123", "password");
        UsuarioJugador desafiado = new UsuarioJugador("Pedro", "pedro456", "password");
        Desafio desafio = new Desafio(desafiante, desafiado, 50);

        desafio.setApuesta(100);
        desafio.setTerminado(true);
        desafio.setComprobado(true);

        assertEquals(100, desafio.getApuesta(), "La apuesta no coincide con el valor esperado después de cambiarla");
        assertTrue(desafio.isTerminado(), "El desafío debería estar terminado después de establecerlo");
        assertTrue(desafio.isComprobado(), "El desafío debería estar comprobado después de establecerlo");
    }
}
