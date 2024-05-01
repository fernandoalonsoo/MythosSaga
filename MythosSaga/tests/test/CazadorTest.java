package test;


import mythossaga.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
public class CazadorTest {

    public CazadorTest() {
    }

    @Test
    public void testGetVoluntad() {
        Habilidad habilidad3 = new Talento("Talento", 1, 2);
        HashMap<String,Arma> armas3 = new HashMap<String,Arma>();
        Arma arma31 = new Arma("La temida Tartaria", 3, 2);
        Arma arma32 = new Arma("Hacha naranja", 3, 1);
        Arma arma33 = new Arma("Espada que cae de canto", 2, 0);
        armas3.put("La temida Tartaria", arma31);
        armas3.put("Hacha naranja", arma32);
        armas3.put("Espada que cae de canto", arma33);

        HashMap<String,Armadura> armaduras3 = new HashMap<String,Armadura>();
        Armadura armadura31 = new Armadura("Brazaletes de Zeus", 0);
        Armadura armadura32 = new Armadura("Camiseta del lol", 2);
        Armadura armadura33 = new Armadura("Pechera de diamante", 1);
        armaduras3.put("Brazaletes de Zeus", armadura31);
        armaduras3.put("Camiseta del lol", armadura32);
        armaduras3.put("Pechera de diamante", armadura33);

        ArrayList<Esbirro> esbirros3 = new ArrayList<Esbirro>();
        Esbirro esbirro31 = new Ghoul(TypeEsbirro.humano, 2, 2);
        Esbirro esbirro32 = new Humano(TypeEsbirro.demonio,3 , Lealtad.ALTO);
        esbirros3.add(esbirro31);
        esbirros3.add(esbirro32);

        ArrayList<Debilidad> debilidades3 = new ArrayList<Debilidad>();
        Debilidad debilidad31 = new Debilidad("Pequeño", 2);
        Debilidad debilidad32 = new Debilidad("Despistado", 3);
        debilidades3.add(debilidad31);
        debilidades3.add(debilidad32);

        ArrayList<Fortaleza> fortalezas3 = new ArrayList<Fortaleza>();
        Fortaleza fortaleza31 = new Fortaleza("Buena punteria", 3);
        Fortaleza fortaleza32 = new Fortaleza("Aguante", 2);
        fortalezas3.add(fortaleza31);
        fortalezas3.add(fortaleza32);

    }

    @Test
    public void testSetVoluntad() {
        Integer voluntad = null;
        Habilidad habilidad3 = new Talento("Talento", 1, 2);
        HashMap<String,Arma> armas3 = new HashMap<String,Arma>();
        Arma arma31 = new Arma("La temida Tartaria", 3, 2);
        Arma arma32 = new Arma("Hacha naranja", 3, 1);
        Arma arma33 = new Arma("Espada que cae de canto", 2, 0);
        armas3.put("La temida Tartaria", arma31);
        armas3.put("Hacha naranja", arma32);
        armas3.put("Espada que cae de canto", arma33);

        HashMap<String,Armadura> armaduras3 = new HashMap<String,Armadura>();
        Armadura armadura31 = new Armadura("Brazaletes de Zeus", 0);
        Armadura armadura32 = new Armadura("Camiseta del lol", 2);
        Armadura armadura33 = new Armadura("Pechera de diamante", 1);
        armaduras3.put("Brazaletes de Zeus", armadura31);
        armaduras3.put("Camiseta del lol", armadura32);
        armaduras3.put("Pechera de diamante", armadura33);

        ArrayList<Esbirro> esbirros3 = new ArrayList<Esbirro>();
        Esbirro esbirro31 = new Ghoul(TypeEsbirro.humano, 2, 2);
        Esbirro esbirro32 = new Humano(TypeEsbirro.demonio,3 , Lealtad.ALTO);
        esbirros3.add(esbirro31);
        esbirros3.add(esbirro32);

        ArrayList<Debilidad> debilidades3 = new ArrayList<Debilidad>();
        Debilidad debilidad31 = new Debilidad("Pequeño", 2);
        Debilidad debilidad32 = new Debilidad("Despistado", 3);
        debilidades3.add(debilidad31);
        debilidades3.add(debilidad32);

        ArrayList<Fortaleza> fortalezas3 = new ArrayList<Fortaleza>();
        Fortaleza fortaleza31 = new Fortaleza("Buena punteria", 3);
        Fortaleza fortaleza32 = new Fortaleza("Aguante", 2);
        fortalezas3.add(fortaleza31);
        fortalezas3.add(fortaleza32);
    }

}
