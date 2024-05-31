package mythossaga;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DemonioTest {

    private Demonio demonio;
    private Esbirro esbirro1;
    private Esbirro esbirro2;

    @Before
    public void setUp() {
        esbirro1 = new Demonio(TypeEsbirro.demonio, 100, "Pacto de Sangre"); // AUX 1
        esbirro2 = new Demonio(TypeEsbirro.demonio, 150, "Pacto de Sangre"); // AUX 2
        demonio = new Demonio(TypeEsbirro.demonio, 200, "Pacto de Sangre");
    }

    @Test
    public void testDemonioConstructor() {
        assertEquals(TypeEsbirro.demonio, demonio.getNombre());
        assertEquals("Pacto de Sangre", demonio.getPacto());
        assertNotNull(demonio.getEsbirros());
    }

    @Test
    public void testGetEsbirros() {
        ArrayList<Esbirro> esbirros = demonio.getEsbirros();
        assertNotNull(esbirros);
        assertTrue(esbirros.isEmpty());
    }

    @Test
    public void testSetEsbirros() {
        ArrayList<Esbirro> esbirros = new ArrayList<>();
        esbirros.add(esbirro1);
        esbirros.add(esbirro2);
        demonio.setEsbirros(esbirros);
        assertEquals(esbirros, demonio.getEsbirros());
    }

    @Test
    public void testAddEsbirros() {
        demonio.addEsbirros(esbirro1);
        assertTrue(demonio.getEsbirros().contains(esbirro1));
        assertEquals(1, demonio.getEsbirros().size());

        demonio.addEsbirros(esbirro2);
        assertTrue(demonio.getEsbirros().contains(esbirro2));
        assertEquals(2, demonio.getEsbirros().size());
    }

    @Test
    public void testGetPacto() {
        assertEquals("Pacto de Sangre", demonio.getPacto());
    }

    @Test
    public void testSetPacto() {
        demonio.setPacto("Nuevo Pacto");
        assertEquals("Nuevo Pacto", demonio.getPacto());
    }
}
