package mythossaga;

import mythossaga.*;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import mythossaga.Vampiro;


public class VampiroTest {

    public VampiroTest() {
    }

    @Test
    public void testSetSalud() {
        Habilidad habilidad1 = new Disciplina("Mataleon", 3, 2, 1);

        HashMap<String,Arma> armas1 = new HashMap<String,Arma>();
        Arma arma11 = new Arma("Martillo de telefonica", 3, 2);
        Arma arma12 = new Arma("Puno de rompe ralf", 2, 1);
        Arma arma13 = new Arma("Espada de en bucle", 2, 2);
        armas1.put("Martillo de telefonica", arma11);
        armas1.put("Puno de rompe ralf", arma12);
        armas1.put("Espada de en bucle", arma13);

        HashMap<String,Armadura> armaduras1 = new HashMap<String,Armadura>();
        Armadura armadura11 = new Armadura("Pechera de diamante", 3);
        Armadura armadura12 = new Armadura("Casco de hierro", 2);
        Armadura armadura13 = new Armadura("Pantalones de fuego", 2);
        armaduras1.put("Pechera de diamante", armadura11);
        armaduras1.put("Casco de hierro", armadura12);
        armaduras1.put("Pantalones de fuego", armadura13);

        ArrayList<Esbirro> esbirros1 = new ArrayList<Esbirro>();
        Esbirro esbirro11 = new Ghoul(TypeEsbirro.ghoul, 3, 3);
        ArrayList<Esbirro> subesbirros = new ArrayList<Esbirro>();
        Esbirro subesbirro1 = new Ghoul(TypeEsbirro.ghoul, 4, 2);
        Esbirro subesbirro2 = new Ghoul(TypeEsbirro.ghoul, 3, 1);
        subesbirros.add(subesbirro1);
        subesbirros.add(subesbirro2);
        Esbirro esbirro12 = new Demonio(TypeEsbirro.demonio, 3, "Vicente");
        esbirros1.add(esbirro11);
        esbirros1.add(esbirro12);
        habilidad1.getAtaque();

        ArrayList<Debilidad> debilidades1 = new ArrayList<Debilidad>();
        Debilidad debilidad11 = new Debilidad("Luz solar", 1);
        Debilidad debilidad12 = new Debilidad("Estaca", 3);
        debilidades1.add(debilidad11);
        debilidades1.add(debilidad12);

        ArrayList<Fortaleza> fortalezas1 = new ArrayList<Fortaleza>();
        Fortaleza fortaleza11 = new Fortaleza("Rayos x", 3);
        Fortaleza fortaleza12 = new Fortaleza("Vista de halcon", 2);
        fortalezas1.add(fortaleza11);
        fortalezas1.add(fortaleza12);

        HashMap<String, Equipo> armasVampiro = new HashMap<>();
        Arma[] armaActivaVampiro = new Arma[10];
        Arma armaVampiro = new Arma("Estoque Sangriento", 4, 1);
        armasVampiro.put(armaVampiro.getNombre(), armaVampiro);

        HashMap<String, Equipo> armadurasVampiro = new HashMap<>();
        Armadura armaduraVampiro = new Armadura("Coraza de la Noche", 3);
        armadurasVampiro.put(armaduraVampiro.getNombre(), armaduraVampiro);

        ArrayList<Modificador> debilidadVampiro = new ArrayList<>();
        ArrayList<Modificador>  fortalezaVampiro = new ArrayList<>();
        ArrayList<Esbirro> esbirrosVampiro = new ArrayList<>();

        // Creación del personaje Vampiro
        Vampiro instance = new Vampiro(
                "VladCazador", // nombre del Vampiro
                armasVampiro, // HashMap de armas
                armaActivaVampiro, // Arreglo de armas activas
                armadurasVampiro, // HashMap de armaduras
                armaduraVampiro, // Armadura activa
                12, // salud
                debilidadVampiro, // Lista de debilidades
                fortalezaVampiro, // Lista de fortalezas
                100, // oro
                25, // poder
                esbirrosVampiro, // Lista de esbirros
                30, // nivel
                15 // experiencia
        );



        Integer saludIni = 1;
        assertEquals(saludIni, instance.getSalud());
    }

    @Test
    public void testSetPuntosSangre() {

        TypeEsbirro tipoHumano = TypeEsbirro.humano;
        TypeEsbirro tipoGhoul = TypeEsbirro.ghoul;
        TypeEsbirro tipoDemonio = TypeEsbirro.demonio;

        HashMap<String,Arma> armas1 = new HashMap<String,Arma>();
        Arma arma11 = new Arma("Martillo de telefonica", 3, 2);
        Arma arma12 = new Arma("Puno de rompe ralf", 2, 1);
        Arma arma13 = new Arma("Espada de en bucle", 2, 2);
        armas1.put("Martillo de telefonica", arma11);
        armas1.put("Puno de rompe ralf", arma12);
        armas1.put("Espada de en bucle", arma13);

        HashMap<String,Armadura> armaduras1 = new HashMap<String,Armadura>();
        Armadura armadura11 = new Armadura("Pechera de diamante", 1);
        Armadura armadura12 = new Armadura("Casco de hierro", 2);
        Armadura armadura13 = new Armadura("Pantalones de fuego", 2);
        armaduras1.put("Pechera de diamante", armadura11);
        armaduras1.put("Casco de hierro", armadura12);
        armaduras1.put("Pantalones de fuego", armadura13);

        ArrayList<Esbirro> esbirros1 = new ArrayList<Esbirro>();
        Esbirro esbirro11 = new Ghoul(tipoGhoul, 3, 3);
        ArrayList<Esbirro> subesbirros = new ArrayList<Esbirro>();
        Esbirro subesbirro1 = new Ghoul(tipoDemonio, 4, 2);
        Esbirro subesbirro2 = new Ghoul(tipoGhoul, 3, 1);
        subesbirros.add(subesbirro1);
        subesbirros.add(subesbirro2);

        Esbirro esbirro12 = new Demonio(tipoHumano, 3, "Esta union es muy fuerte y nunca será rota");
        esbirros1.add(esbirro11);
        esbirros1.add(esbirro12);

        ArrayList<Debilidad> debilidades1 = new ArrayList<Debilidad>();
        Debilidad debilidad11 = new Debilidad("Luz solar", 1);
        Debilidad debilidad12 = new Debilidad("Estaca", 3);
        debilidades1.add(debilidad11);
        debilidades1.add(debilidad12);

        ArrayList<Fortaleza> fortalezas1 = new ArrayList<Fortaleza>();
        Fortaleza fortaleza11 = new Fortaleza("Rayos x", 3);
        Fortaleza fortaleza12 = new Fortaleza("Vista de halcon", 2);
        fortalezas1.add(fortaleza11);
        fortalezas1.add(fortaleza12);

        HashMap<String, Equipo> armasVampiro = new HashMap<>();
        Arma[] armaActivaVampiro = new Arma[10];
        Arma armaVampiro = new Arma("Estoque Sangriento", 4, 1);
        armasVampiro.put(armaVampiro.getNombre(), armaVampiro);

        HashMap<String, Equipo> armadurasVampiro = new HashMap<>();
        Armadura armaduraVampiro = new Armadura("Coraza de la Noche", 3);
        armadurasVampiro.put(armaduraVampiro.getNombre(), armaduraVampiro);

        ArrayList<Modificador> debilidadVampiro = new ArrayList<>();
        ArrayList<Modificador>  fortalezaVampiro = new ArrayList<>();
        ArrayList<Esbirro> esbirrosVampiro = new ArrayList<>();

        // Creación del personaje Vampiro
        Vampiro instance = new Vampiro(
                "VladCazador", // nombre del Vampiro
                armasVampiro, // HashMap de armas
                armaActivaVampiro, // Arreglo de armas activas
                armadurasVampiro, // HashMap de armaduras
                armaduraVampiro, // Armadura activa
                12, // salud
                debilidadVampiro, // Lista de debilidades
                fortalezaVampiro, // Lista de fortalezas
                100, // oro
                25, // poder
                esbirrosVampiro, // Lista de esbirros
                30, // nivel
                15 // experiencia
        );

        Integer puntosSangre = 5;
        instance.setPuntosSangre(puntosSangre);
    }

    @Test
    public void testGetOro() {
        Habilidad habilidad1 = new Disciplina("Matamoscas", 4, 2, 1);

        HashMap<String,Arma> armas1 = new HashMap<String,Arma>();
        Arma arma11 = new Arma("Martillo de telefonica", 3, 2);
        Arma arma12 = new Arma("Puno de rompe ralf", 2, 1);
        Arma arma13 = new Arma("Espada de en bucle", 2, 0);
        armas1.put("Martillo de telefonica", arma11);
        armas1.put("Puno de rompe ralf", arma12);
        armas1.put("Espada de en bucle", arma13);

        HashMap<String,Armadura> armaduras1 = new HashMap<String,Armadura>();
        Armadura armadura11 = new Armadura("Pechera de diamante", 1);
        Armadura armadura12 = new Armadura("Casco de hierro", 2);
        Armadura armadura13 = new Armadura("Pantalones de fuego", 2);
        armaduras1.put("Pechera de diamante", armadura11);
        armaduras1.put("Casco de hierro", armadura12);
        armaduras1.put("Pantalones de fuego", armadura13);

        ArrayList<Esbirro> esbirros1 = new ArrayList<Esbirro>();
        Esbirro esbirro11 = new Ghoul( TypeEsbirro.ghoul,4, 3);
        ArrayList<Esbirro> subesbirros = new ArrayList<Esbirro>();
        Esbirro subesbirro1 = new Ghoul(TypeEsbirro.ghoul, 4, 2);
        Esbirro subesbirro2 = new Ghoul(TypeEsbirro.ghoul, 3, 1);
        subesbirros.add(subesbirro1);
        subesbirros.add(subesbirro2);
        Esbirro esbirro12 = new Demonio(TypeEsbirro.demonio, 3, "Vicente");
        esbirros1.add(esbirro11);
        esbirros1.add(esbirro12);

        ArrayList<Debilidad> debilidades1 = new ArrayList<Debilidad>();
        Debilidad debilidad11 = new Debilidad("Luz solar", 1);
        Debilidad debilidad12 = new Debilidad("Estaca", 3);
        debilidades1.add(debilidad11);
        debilidades1.add(debilidad12);

        ArrayList<Fortaleza> fortalezas1 = new ArrayList<Fortaleza>();
        Fortaleza fortaleza11 = new Fortaleza("Rayos x", 3);
        Fortaleza fortaleza12 = new Fortaleza("Vista de halcon", 2);
        fortalezas1.add(fortaleza11);
        fortalezas1.add(fortaleza12);

        HashMap<String, Equipo> armasVampiro = new HashMap<>();
        Arma[] armaActivaVampiro = new Arma[10];
        Arma armaVampiro = new Arma("Estoque Sangriento", 4, 1);
        armasVampiro.put(armaVampiro.getNombre(), armaVampiro);

        HashMap<String, Equipo> armadurasVampiro = new HashMap<>();
        Armadura armaduraVampiro = new Armadura("Coraza de la Noche", 3);
        armadurasVampiro.put(armaduraVampiro.getNombre(), armaduraVampiro);

        ArrayList<Modificador> debilidadVampiro = new ArrayList<>();
        ArrayList<Modificador>  fortalezaVampiro = new ArrayList<>();
        ArrayList<Esbirro> esbirrosVampiro = new ArrayList<>();

        // Creación del personaje Vampiro
        Personaje instance = new Vampiro(
                "VladCazador", // nombre del Vampiro
                armasVampiro, // HashMap de armas
                armaActivaVampiro, // Arreglo de armas activas
                armadurasVampiro, // HashMap de armaduras
                armaduraVampiro, // Armadura activa
                12, // salud
                debilidadVampiro, // Lista de debilidades
                fortalezaVampiro, // Lista de fortalezas
                100, // oro
                25, // poder
                esbirrosVampiro, // Lista de esbirros
                30, // nivel
                15 // experiencia
        );

        Double expResult = 100d;
        Double result = instance.getOro();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPuntosSangre() {
        Habilidad habilidad1 = new Disciplina("Mataleon", 3, 2, 1);

        HashMap<String,Arma> armas1 = new HashMap<String,Arma>();
        Arma arma11 = new Arma("Martillo de telefonica", 3,  1);
        Arma arma12 = new Arma("Puno de rompe ralf", 2, 1);
        Arma arma13 = new Arma("Espada de en bucle", 2, 2);
        armas1.put("Martillo de telefonica", arma11);
        armas1.put("Puno de rompe ralf", arma12);
        armas1.put("Espada de en bucle", arma13);

        HashMap<String,Armadura> armaduras1 = new HashMap<String,Armadura>();
        Armadura armadura11 = new Armadura("Pechera de diamante", 1);
        Armadura armadura12 = new Armadura("Casco de hierro", 2);
        Armadura armadura13 = new Armadura("Pantalones de fuego", 2);
        armaduras1.put("Pechera de diamante", armadura11);
        armaduras1.put("Casco de hierro", armadura12);
        armaduras1.put("Pantalones de fuego", armadura13);

        ArrayList<Esbirro> esbirros1 = new ArrayList<Esbirro>();
        Esbirro esbirro11 = new Ghoul(TypeEsbirro.ghoul, 3, 3);
        ArrayList<Esbirro> subesbirros = new ArrayList<Esbirro>();
        Esbirro subesbirro1 = new Ghoul(TypeEsbirro.ghoul, 2, 2);
        Esbirro subesbirro2 = new Ghoul(TypeEsbirro.ghoul, 1, 1);
        subesbirros.add(subesbirro1);
        subesbirros.add(subesbirro2);
        Esbirro esbirro12 = new Demonio(TypeEsbirro.demonio, 3, "Vicente");
        esbirros1.add(esbirro11);
        esbirros1.add(esbirro12);
        habilidad1.getDefensa();

        ArrayList<Debilidad> debilidades1 = new ArrayList<Debilidad>();
        Debilidad debilidad11 = new Debilidad("Luz solar", 1);
        Debilidad debilidad12 = new Debilidad("Estaca", 3);
        debilidades1.add(debilidad11);
        debilidades1.add(debilidad12);

        ArrayList<Fortaleza> fortalezas1 = new ArrayList<Fortaleza>();
        Fortaleza fortaleza11 = new Fortaleza("Rayos x", 3);
        Fortaleza fortaleza12 = new Fortaleza("Vista de halcon", 2);
        fortalezas1.add(fortaleza11);
        fortalezas1.add(fortaleza12);

        HashMap<String, Equipo> armasVampiro = new HashMap<>();
        Arma[] armaActivaVampiro = new Arma[10];
        Arma armaVampiro = new Arma("Estoque Sangriento", 4, 1);
        armasVampiro.put(armaVampiro.getNombre(), armaVampiro);

        HashMap<String, Equipo> armadurasVampiro = new HashMap<>();
        Armadura armaduraVampiro = new Armadura("Coraza de la Noche", 3);
        armadurasVampiro.put(armaduraVampiro.getNombre(), armaduraVampiro);

        ArrayList<Modificador> debilidadVampiro = new ArrayList<>();
        ArrayList<Modificador>  fortalezaVampiro = new ArrayList<>();
        ArrayList<Esbirro> esbirrosVampiro = new ArrayList<>();

        // Creación del personaje Vampiro
        Vampiro instance = new Vampiro(
                "VladCazador", // nombre del Vampiro
                armasVampiro, // HashMap de armas
                armaActivaVampiro, // Arreglo de armas activas
                armadurasVampiro, // HashMap de armaduras
                armaduraVampiro, // Armadura activa
                12, // salud
                debilidadVampiro, // Lista de debilidades
                fortalezaVampiro, // Lista de fortalezas
                100, // oro
                25, // poder
                esbirrosVampiro, // Lista de esbirros
                30, // nivel
                15 // experiencia
        );


        Integer expResult = 15;
        Integer result = instance.getPuntosSangre();
        assertEquals(expResult, result);
    }

}
