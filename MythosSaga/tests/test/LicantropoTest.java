package test;

import mythossaga.*;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class LicantropoTest {

    public LicantropoTest() {
    }

    @Test
    public void testGetRabia() {
        Habilidad habilidad2 = new Dones("Don", 3, 2, 2);
        HashMap<String,Arma> armas2 = new HashMap<String,Arma>();
        Arma arma21 = new Arma("Super vaso pitufo", 3, 2);
        Arma arma22 = new Arma("Botella de el poderoso love", 1, 1);
        Arma arma23 = new Arma("Espada de kruskal", 2, 2);
        armas2.put("Super vaso pitufo", arma21);
        armas2.put("Botella de el poderoso love", arma22);
        armas2.put("Espada de kruskal", arma23);

        HashMap<String,Armadura> armaduras2 = new HashMap<String,Armadura>();
        Armadura armadura21 = new Armadura("Botas de moises", 1);
        Armadura armadura22 = new Armadura("Pechera de diamante",  3);
        Armadura armadura23 = new Armadura("Casco de motero", 2);
        armaduras2.put("Botas de moises", armadura21);
        armaduras2.put("Pechera de diamante", armadura22);
        armaduras2.put("Casco de motero", armadura23);
        habilidad2.getDefensa();

        ArrayList<Esbirro> esbirros2 = new ArrayList<Esbirro>();
        Esbirro esbirro21 = new Humano(TypeEsbirro.humano, 3, Lealtad.ALTO);
        Esbirro esbirro22 = new Ghoul(TypeEsbirro.ghoul, 3, 1);
        esbirros2.add(esbirro21);
        esbirros2.add(esbirro22);

        ArrayList<Debilidad> debilidades2 = new ArrayList<Debilidad>();
        Debilidad debilidad21 = new Debilidad("Barro", 1);
        Debilidad debilidad22 = new Debilidad("Presa facil", 4);
        debilidades2.add(debilidad21);
        debilidades2.add(debilidad22);

        ArrayList<Fortaleza> fortalezas2 = new ArrayList<Fortaleza>();
        Fortaleza fortaleza21 = new Fortaleza("Fuerza bruta", 2);
        Fortaleza fortaleza22 = new Fortaleza("Garras", 2);
        fortalezas2.add(fortaleza21);
        fortalezas2.add(fortaleza22);
        HashMap<String, Equipo> armasLicantropo = new HashMap<>();
        Arma[] armaActivaLicantropo = new Arma[10];
        Arma armaLicantropo = new Arma("Espada de Plata", 7, 1);
        armasLicantropo.put(armaLicantropo.getNombre(), armaLicantropo);

        HashMap<String, Equipo> armadurasLicantropo = new HashMap<>();
        Armadura armaduraLicantropo = new Armadura("Cota de Mallas", 4);
        armadurasLicantropo.put(armaduraLicantropo.getNombre(), armaduraLicantropo);

        ArrayList<Modificador>  debilidadesLicantropo = new ArrayList<>();
        ArrayList<Modificador>  fortalezasLicantropo = new ArrayList<>();
        ArrayList<Esbirro> esbirrosLicantropo = new ArrayList<>();

        // Creación del personaje Licantropo
        Integer rabiaInicial = 50; // Valor inicial de rabia para el Licantropo
        Licantropo instance = new Licantropo(
                "GuerreroLunar", // nombre del Licantropo
                armasLicantropo, // HashMap de armas
                armaActivaLicantropo, // Arreglo de armas activas
                armadurasLicantropo, // HashMap de armaduras
                armaduraLicantropo, // Armadura activa
                15, // salud
                debilidadesLicantropo, // Lista de debilidades
                fortalezasLicantropo, // Lista de fortalezas
                100, // oro
                20, // poder
                esbirrosLicantropo, // Lista de esbirros
                rabiaInicial // rabia
        );

        Integer rabia = 1;
        assertEquals(rabia, instance.getRabia());
        instance.setRabia(rabia);
        assertEquals(rabia, instance.getRabia());
    }

    @Test
    public void testSetRabia() {
        Integer rabia = 1;
        Habilidad habilidad2 = new Dones("Don", 3,  2, 2);
        HashMap<String,Arma> armas2 = new HashMap<String,Arma>();
        Arma arma21 = new Arma("Super vaso pitufo", 3, 2);
        Arma arma22 = new Arma("Botella de el poderoso love", 1, 1);
        Arma arma23 = new Arma("Espada de kruskal", 2, 0);
        armas2.put("Super vaso pitufo", arma21);
        armas2.put("Botella de el poderoso love", arma22);
        armas2.put("Espada de kruskal", arma23);

        HashMap<String,Armadura> armaduras2 = new HashMap<String,Armadura>();
        Armadura armadura21 = new Armadura("Botas de moises", 2);
        Armadura armadura22 = new Armadura("Pechera de diamante", 1);
        Armadura armadura23 = new Armadura("Casco de motero", 2);
        armaduras2.put("Botas de moises", armadura21);
        armaduras2.put("Pechera de diamante", armadura22);
        armaduras2.put("Casco de motero", armadura23);

        ArrayList<Esbirro> esbirros2 = new ArrayList<Esbirro>();
        Esbirro esbirro21 = new Humano(TypeEsbirro.humano,3 , Lealtad.ALTO);
        Esbirro esbirro22 = new Ghoul(TypeEsbirro.ghoul, 4, 1);
        esbirros2.add(esbirro21);
        esbirros2.add(esbirro22);

        ArrayList<Debilidad> debilidades2 = new ArrayList<Debilidad>();
        Debilidad debilidad21 = new Debilidad("Barro", 1);
        Debilidad debilidad22 = new Debilidad("Presa facil", 4);
        debilidades2.add(debilidad21);
        debilidades2.add(debilidad22);

        ArrayList<Fortaleza> fortalezas2 = new ArrayList<Fortaleza>();
        Fortaleza fortaleza21 = new Fortaleza("Fuerza bruta", 2);
        Fortaleza fortaleza22 = new Fortaleza("Garras", 2);
        fortalezas2.add(fortaleza21);
        fortalezas2.add(fortaleza22);
        HashMap<String, Equipo> armasLicantropo = new HashMap<>();
        Arma[] armaActivaLicantropo = new Arma[10];
        Arma armaLicantropo = new Arma("Espada de Plata", 7, 1);
        armasLicantropo.put(armaLicantropo.getNombre(), armaLicantropo);

        HashMap<String, Equipo> armadurasLicantropo = new HashMap<>();
        Armadura armaduraLicantropo = new Armadura("Cota de Mallas", 4);
        armadurasLicantropo.put(armaduraLicantropo.getNombre(), armaduraLicantropo);

        ArrayList<Modificador>  debilidadesLicantropo = new ArrayList<>();
        ArrayList<Modificador>  fortalezasLicantropo = new ArrayList<>();
        ArrayList<Esbirro> esbirrosLicantropo = new ArrayList<>();

        // Creación del personaje Licantropo
        Integer rabiaInicial = 50; // Valor inicial de rabia para el Licantropo
        Licantropo instance = new Licantropo(
                "GuerreroLunar", // nombre del Licantropo
                armasLicantropo, // HashMap de armas
                armaActivaLicantropo, // Arreglo de armas activas
                armadurasLicantropo, // HashMap de armaduras
                armaduraLicantropo, // Armadura activa
                15, // salud
                debilidadesLicantropo, // Lista de debilidades
                fortalezasLicantropo, // Lista de fortalezas
                100, // oro
                20, // poder
                esbirrosLicantropo, // Lista de esbirros
                rabiaInicial // rabia
        );

        instance.setRabia(rabia);
    }

}
