package mythossaga;

import mythossaga.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EsbirroTest {

    @Test
    void getNombreEsbirroDemonio(){
        Esbirro esbirro = new Demonio(TypeEsbirro.demonio, 3, "Ofrezco poder y gloria a cambio de tu alma " );

        assertEquals(esbirro.getNombre(), TypeEsbirro.demonio);
        assertNotEquals(esbirro.getNombre(), TypeEsbirro.humano);
    }

    @Test
    void lealtadEsbirro(){
        Humano esbirro = new Humano(TypeEsbirro.humano, 2, Lealtad.ALTO);
        assertInstanceOf(Humano.class, esbirro);
        Lealtad l = esbirro.getLealtad();
        assertNotEquals(l, Lealtad.NORMAL);
    }

    @Test
    void dependenciaEsbirroError(){
        Ghoul esbirro = new Ghoul(TypeEsbirro.ghoul, 1, 3);
        assertInstanceOf(Ghoul.class, esbirro);
        //Error
        assertNull(esbirro.getDependencia());
    }
}
