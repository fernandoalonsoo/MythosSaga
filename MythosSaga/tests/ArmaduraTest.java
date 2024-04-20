import mythossaga.Armadura;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArmaduraTest {

    @Test
    public void testGetValorDefensa() {
        // Arrange
        Armadura armadura = new Armadura("Escudo", 5);

        // Act
        int valorDefensa = armadura.getValorDefensa();

        // Assert
        assertEquals(5, valorDefensa, "El valor de defensa debe ser igual al modificador de la armadura");
    }

    @Test
    public void testToString() {
        // Arrange
        Armadura armadura = new Armadura("Escudo", 5);

        // Act
        String resultado = armadura.toString();

        // Assert
        assertEquals("Nombre: Escudo, Modificador de defensa: 5", resultado,
                "El método toString() debe devolver una cadena formateada correctamente");
    }
}
