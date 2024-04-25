package test;

import mythossaga.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SistemaTest {

    Sistema sistema = new Sistema();
    HashMap<String, User> usuarios = sistema.getUsuarios();

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void testNumeroRegistroDistintos() {

    }

    @Test
    void menuInicio() {
    }


}