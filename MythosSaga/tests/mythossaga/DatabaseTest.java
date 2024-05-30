package mythossaga;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
        database.inicializarDatabase();
    }

    @Test
    public void testGetUsuarios() {
        HashMap<String, User> usuarios = database.getUsuarios();
        assertNotNull(usuarios);
    }

    @Test
    public void testGetDesafios() {
        ArrayList<Desafio> desafios = database.getDesafios();
        assertNotNull(desafios);
    }

    @Test
    public void testSaveData() throws FileNotFoundException, IOException {
        database.saveData();
        // No assertEquals here because the method does not return anything
    }

    @Test
    public void testCheckNick() {
        User user = new UsuarioJugador("nombre", "nick", "password");
        boolean result = database.checkNick("testNick");
        assertTrue(result);
    }

    @Test
    public void testNuevoUsuario() {
        User user = new UsuarioJugador("nombre", "nick", "password");
        database.nuevoUsuario(user);
        assertEquals(user, database.getUsuarios().get("newUser"));
    }

    @Test
    public void testEliminarUsuario() {
        User user = new UsuarioJugador("nombre", "nick", "password");
        database.nuevoUsuario(user);
        database.eliminarUsuario("deleteUser");
        assertNull(database.getUsuarios().get("deleteUser"));
    }

    @Test
    public void testCheckLogIN() {
        User user = new UsuarioJugador("nombre", "nick", "password");
        database.nuevoUsuario(user);
        boolean result = database.checkLogIN("loginUser", "password");
        assertTrue(result);
    }

    @Test
    public void testCrearDesafio() {
        UsuarioJugador desafiante = new UsuarioJugador("desafiante", "nick", "password");
        UsuarioJugador desafiado = new UsuarioJugador("desafiado", "nick", "password");
        database.crearDesafio(desafiante, desafiado, 100);
        assertEquals(1, database.getDesafios().size());
    }

    @Test
    public void testInicializarDatabase() {
        database.inicializarDatabase();
        assertNotNull(database.getUsuarios());
        assertNotNull(database.getDesafios());
    }

    @Test
    public void testGetArmas() {
        ArrayList<Arma> armas = database.getArmas();
        assertNotNull(armas);
    }

    @Test
    public void testSetArmas() {
        ArrayList<Arma> armas = new ArrayList<>();
        database.setArmas(armas);
        assertEquals(armas, database.getArmas());
    }

    @Test
    public void testAddArmas() {
        Arma arma = new Arma("nombre", 1, 1);
        database.addArmas(arma);
        assertTrue(database.getArmas().contains(arma));
    }

    @Test
    public void testGetArmaduras() {
        ArrayList<Armadura> armaduras = database.getArmaduras();
        assertNotNull(armaduras);
    }

    @Test
    public void testSetArmaduras() {
        ArrayList<Armadura> armaduras = new ArrayList<>();
        database.setArmaduras(armaduras);
        assertEquals(armaduras, database.getArmaduras());
    }

    @Test
    public void testAddArmaduras() {
        Armadura armadura = new Armadura("nombre", 1);
        database.addArmaduras(armadura);
        assertTrue(database.getArmaduras().contains(armadura));
    }

    @Test
    public void testGetMensajesCazadores() {
        ArrayList<String> mensajesCazadores = database.getMensajesCazadores();
        assertNotNull(mensajesCazadores);
    }

    @Test
    public void testGetMensajesLicantropos() {
        ArrayList<String> mensajesLicantropos = database.getMensajesLicantropos();
        assertNotNull(mensajesLicantropos);
    }

    @Test
    public void testGetMensajesVampiros() {
        ArrayList<String> mensajesVampiros = database.getMensajesVampiros();
        assertNotNull(mensajesVampiros);
    }
}
