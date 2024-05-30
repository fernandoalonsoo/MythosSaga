package mythossaga;

import mythossaga.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonajeTest {
    @Test
    public void testPersonajes(){
    Personaje instanceC = new Cazador("Fer");
    Personaje instanceL = new Licantropo("Fer");
    Personaje instanceV = new Vampiro("Fer");
    assertNotEquals(instanceV, instanceL);
    assertNotEquals(instanceV, instanceC);
    assertNotEquals(instanceL, instanceC);
    }

    @Test
    public void testPersonajesFallido(){
        //Error
        Personaje instanceC = new Cazador("Fer");
        Personaje instanceL = new Licantropo("Fer");
        Personaje instanceV = new Vampiro("Fer");
        assertEquals(instanceV, instanceL);
        assertEquals(instanceV, instanceC);
        assertEquals(instanceL, instanceC);
    }

    @Test
    public void testAddArma(){
        Personaje instance = new Cazador("G");
        Arma arma1 = new Arma("Espada", 2, 0);
        instance.addArmas(arma1);
        assertFalse(instance.getArmas().isEmpty());
        assertTrue(instance.getArmas().containsValue(arma1));
        assertEquals(arma1, instance.getArmas().get("Espada"));
    }

    @Test
    public void testCreatePersonajeWithArmadura(){
        List<Equipo> armaduras = new ArrayList<>();
        Armadura armadura1 = new Armadura("Cota de mallas", 3);
        Personaje instance = new Cazador("J", null, null, armaduras, null, 1, null, null, 10, 1, null, 1);
        instance.addArmadura(armadura1);
        instance.setArmaduraActiva(armadura1);
        assertTrue(instance.getArmaduras().containsValue(instance.getArmaduraActiva()));
        assertTrue(instance.getArmaduras().containsValue(armadura1));
        Armadura armadura2 = new Armadura("Cota", 4);
        HashMap<String,Equipo> armaduraM = new HashMap<String,Equipo>();
        armaduraM.put("Cota", armadura2);
        instance.setArmaduras(armaduraM);
        assertTrue(instance.getArmaduras().containsValue(armadura2));
    }
}