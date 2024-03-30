package mythossaga;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Database implements Serializable {

    private HashMap<String, User> usuarios;
    private ArrayList<Desafio> desafios;

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

        Operador fer = new Operador("fer", "nano", "1234");

        UsuarioJugador juan = new UsuarioJugador("jrb", "jrb", "1234");

        UsuarioJugador guille = new UsuarioJugador("guille", "guille", "1234");

        UsuarioJugador alex = new UsuarioJugador("alex", "alex", "1234");

        Personaje personaje1 = new Personaje("jrb", 4, 3);
        Personaje personaje2 = new Personaje("guille", 4, 3);
        Personaje personaje3 = new Personaje("alex", 4, 3);

        juan.crearPersonaje(personaje1);
        guille.crearPersonaje(personaje2);
        alex.crearPersonaje(personaje3);

        this.usuarios.put(fer.getNick(), fer);
        this.usuarios.put(juan.getNick(), juan);
        this.usuarios.put(guille.getNick(), guille);
        this.usuarios.put(alex.getNick(), alex);
    }
}
