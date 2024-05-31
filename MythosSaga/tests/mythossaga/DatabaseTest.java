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
    private User user;

    @Before
    public void setUp() {
        database = new Database();
        database.inicializarDatabase();
        user = new UsuarioJugador("nombre","nick", "password");
    }

    @Test
    public void testGetUsuarios() {
        HashMap<String, User> usuarios = database.getUsuarios();
        assertNotNull(usuarios);
    }

    @Test
    public void testGetDesafios() {
        assertNotNull(database.getDesafios());
    }

    @Test
    public void testSaveData() throws FileNotFoundException, IOException {
        database.saveData();
        // No assertEquals here because the method does not return anything
    }

    @Test
    public void testCheckNick() {
        database.nuevoUsuario(user);
        boolean result = database.checkNick("nick");
        assertTrue(result);
    }

    @Test
    public void testNuevoUsuario() {
        database.nuevoUsuario(user);
        assertEquals(user, database.getUsuarios().get("nick"));
    }

    @Test
    public void testEliminarUsuario() {
        database.nuevoUsuario(user);
        database.eliminarUsuario("nick");
        assertNull(database.getUsuarios().get("nick"));
    }

    @Test
    public void testCheckLogIN() {
        database.nuevoUsuario(user);
        boolean result = database.checkLogIN("nick", "password");
        assertTrue(result);
    }

    @Test
    public void testCrearDesafio() {
        database.getDesafios().clear();  // Asegúrate de que la lista de desafíos esté vacía antes de empezar la prueba
        UsuarioJugador desafiante = new UsuarioJugador("nombre","nick", "password");
        UsuarioJugador desafiado = new UsuarioJugador("nombre","nick", "password");
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
        assertNotNull(database.getArmas());
    }

    @Test
    public void testSetArmas() {
        ArrayList<Arma> armas = new ArrayList<>();
        database.setArmas(armas);
        assertEquals(armas, database.getArmas());
    }

    @Test
    public void testAddArmas() {
        Arma arma = new Arma("Espada", 10, 1);
        database.addArmas(arma);
        assertTrue(database.getArmas().contains(arma));
    }

    @Test
    public void testGetArmaduras() {
        assertNotNull(database.getArmaduras());
    }

    @Test
    public void testSetArmaduras() {
        ArrayList<Armadura> armaduras = new ArrayList<>();
        database.setArmaduras(armaduras);
        assertEquals(armaduras, database.getArmaduras());
    }

    @Test
    public void testAddArmaduras() {
        Armadura armadura = new Armadura("Cota de malla", 15);
        database.addArmaduras(armadura);
        assertTrue(database.getArmaduras().contains(armadura));
    }

    @Test
    public void testGetMensajesCazadores() {
        assertNotNull(database.getMensajesCazadores());
    }

    @Test
    public void testGetMensajesLicantropos() {
        assertNotNull(database.getMensajesLicantropos());
    }

    @Test
    public void testGetMensajesVampiros() {
        assertNotNull(database.getMensajesVampiros());
    }
}
