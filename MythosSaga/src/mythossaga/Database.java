package mythossaga;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Database implements Serializable {

    private HashMap<String, User> usuarios;
    private ArrayList<Desafio> desafios;
    private ArrayList<Arma> armas;
    private ArrayList<Armadura> armaduras;

    public HashMap<String, User> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Desafio> getDesafios() {
        return desafios;
    }

    public void saveData() throws FileNotFoundException, IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("database/data.data"));
        out.writeObject(this);
        out.close();
    }

    //Comprueba si el nick esta en uso
    public boolean checkNick(String nick){
        return usuarios.containsKey(nick);
    }

    // Metodo que añade un nuevo usuario a la lista de usuarios que luego irá a la base de datos
    public void nuevoUsuario(User usuario) {
        usuarios.put(usuario.getNick(), usuario);
    }

    // Metodo que busca a un usuario por su nickname en la base de datos y si lo encuentra lo elimina
    public void eliminarUsuario(String nick) {
        usuarios.remove(nick);
        }



    public boolean checkLogIN(String nick, String password){
        if(usuarios.containsKey(nick))
            return password.equals(usuarios.get(nick).getPassword());
        return false;
    }

    public void crearDesafio(String nick, String desafiado, int oroApostado) {
        Desafio desafio = new Desafio(nick, desafiado, oroApostado);
        desafios.add(desafio);
    }

    public void inicializarDatabase(){
        this.usuarios =  new HashMap<>();
        this.desafios =  new ArrayList<>();
        this.armas = new ArrayList<>();
        this.armaduras = new ArrayList<>();

        // El operador para gestionar los desafios
        Operador fer = new Operador("fer", "nano", "1234");
        this.usuarios.put(fer.getNick(), fer);


        /////////////////////////
        // El usuario de juan
        /////////////////////////


        UsuarioJugador juan = new UsuarioJugador("jrb", "jrb", "1234");

        HashMap<String, Equipo> armasVampiro = new HashMap<>();
        Arma[] armaActivaVampiro = new Arma[10];
        Arma armaVampiro = new Arma("Estoque Sangriento", 4, 1);
        armasVampiro.put(armaVampiro.getNombre(), armaVampiro);

        HashMap<String, Equipo> armadurasVampiro = new HashMap<>();
        Armadura armaduraVampiro = new Armadura("Coraza de la Noche", 3);
        armadurasVampiro.put(armaduraVampiro.getNombre(), armaduraVampiro);

        List<Modificador> debilidadesVampiro = new ArrayList<>();
        List<Modificador> fortalezasVampiro = new ArrayList<>();
        List<Esbirro> esbirrosVampiro = new ArrayList<>();

        // Creación del personaje Vampiro
        Personaje personajeVampiro = new Vampiro(
                "VladCazador", // nombre del Vampiro
                armasVampiro, // HashMap de armas
                armaActivaVampiro, // Arreglo de armas activas
                armadurasVampiro, // HashMap de armaduras
                armaduraVampiro, // Armadura activa
                12, // salud
                debilidadesVampiro, // Lista de debilidades
                fortalezasVampiro, // Lista de fortalezas
                100, // oro
                25, // poder
                esbirrosVampiro, // Lista de esbirros
                30, // nivel
                15 // experiencia
        );
        juan.crearPersonaje(personajeVampiro);
        this.usuarios.put(juan.getNick(), juan);


        /////////////////////////
        // El usuario de guille
        /////////////////////////


        UsuarioJugador guille = new UsuarioJugador("guille", "guille", "1234");

        HashMap<String, Equipo> armasLicantropo = new HashMap<>();
        Arma[] armaActivaLicantropo = new Arma[10];
        Arma armaLicantropo = new Arma("Espada de Plata", 7, 1);
        armasLicantropo.put(armaLicantropo.getNombre(), armaLicantropo);

        HashMap<String, Equipo> armadurasLicantropo = new HashMap<>();
        Armadura armaduraLicantropo = new Armadura("Cota de Mallas", 4);
        armadurasLicantropo.put(armaduraLicantropo.getNombre(), armaduraLicantropo);

        List<Modificador> debilidadesLicantropo = new ArrayList<>();
        List<Modificador> fortalezasLicantropo = new ArrayList<>();
        List<Esbirro> esbirrosLicantropo = new ArrayList<>();

        // Creación del personaje Licantropo
        Integer rabiaInicial = 50; // Valor inicial de rabia para el Licantropo
        Personaje personajeLicantropo = new Licantropo(
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
        guille.crearPersonaje(personajeLicantropo);
        this.usuarios.put(guille.getNick(), guille);


        /////////////////////////
        // El usuario de alex
        /////////////////////////


        UsuarioJugador alex = new UsuarioJugador("alex", "alex", "1234");

        HashMap<String, Equipo> armasCazador = new HashMap<>();
        Arma[] armaActivaCazador = new Arma[10];
        Arma armaCazador = new Arma("Ballesta Ligera", 5, 2);
        armasCazador.put(armaCazador.getNombre(), armaCazador);

        HashMap<String, Equipo> armadurasCazador = new HashMap<>();
        Armadura armaduraCazador = new Armadura("Vestimentas de Cuero", 2);
        armadurasCazador.put(armaduraCazador.getNombre(), armaduraCazador);

        List<Modificador> debilidadesCazador = new ArrayList<>();
        List<Modificador> fortalezasCazador = new ArrayList<>();
        List<Esbirro> esbirrosCazador = new ArrayList<>();

        // Creación del personaje Cazador
        Integer voluntadInicial = 40; // Valor inicial de voluntad para el Cazador
        Personaje personajeCazador = new Cazador(
                "Artemis", // nombre del Cazador
                new ArrayList<>(armasCazador.values()), // Lista de armas
                armaCazador, // Arma activa
                new ArrayList<>(armadurasCazador.values()), // Lista de armaduras
                armaduraCazador, // Armadura activa
                100, // salud
                debilidadesCazador, // Lista de debilidades
                fortalezasCazador, // Lista de fortalezas
                100, // oro
                10, // poder
                esbirrosCazador, // Lista de esbirros
                voluntadInicial // voluntad
        );
        alex.crearPersonaje(personajeCazador);
        this.usuarios.put(alex.getNick(), alex);


        // Inicializamos unas armas
        Arma arma1 = new Arma("Espada Corta", 3, 1);
        Arma arma2 = new Arma("Hacha de Batalla", 6, 2);
        Arma arma3 = new Arma("Daga Venenosa", 2, 1);
        Arma arma4 = new Arma("Martillo de Guerra", 5, 2);
        Arma arma5 = new Arma("Arco Largo", 4, 2);
        Arma arma6 = new Arma("Cimitarra", 3, 1);
        Arma arma7 = new Arma("Lanza de Caballería", 4, 2);
        Arma arma8 = new Arma("Ballesta Pesada", 5, 2);
        Arma arma9 = new Arma("Estoque", 2, 1);
        Arma arma10 = new Arma("Maza de Hierro", 4, 1);

        this.armas.add(arma1);
        this.armas.add(arma2);
        this.armas.add(arma3);
        this.armas.add(arma4);
        this.armas.add(arma5);
        this.armas.add(arma6);
        this.armas.add(arma7);
        this.armas.add(arma8);
        this.armas.add(arma9);
        this.armas.add(arma10);

        // Inicializamos unas armaduras

        Armadura armadura1 = new Armadura("Casco de Hierro", 2);
        Armadura armadura2 = new Armadura("Pechera de Acero", 5);
        Armadura armadura3 = new Armadura("Grebas de Cuero", 1);
        Armadura armadura4 = new Armadura("Guanteletes de Plata", 3);
        Armadura armadura5 = new Armadura("Botas de Mithril", 4);
        Armadura armadura6 = new Armadura("Espaldarones de Bronce", 3);
        Armadura armadura7 = new Armadura("Cinturón de Fuerza", 2);
        Armadura armadura8 = new Armadura("Capa de Invisibilidad", 1);
        Armadura armadura9 = new Armadura("Brazales de Guardián", 2);
        Armadura armadura10 = new Armadura("Yelmo del Dragón", 4);

        this.armaduras.add(armadura1);
        this.armaduras.add(armadura2);
        this.armaduras.add(armadura3);
        this.armaduras.add(armadura4);
        this.armaduras.add(armadura5);
        this.armaduras.add(armadura6);
        this.armaduras.add(armadura7);
        this.armaduras.add(armadura8);
        this.armaduras.add(armadura9);
        this.armaduras.add(armadura10);
    }
}

