package Tests.Sorteo;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import Sorteo.Participante;
import Usuario.ClienteRegistrado;

public class ParticipanteTest {
    private ClienteRegistrado cliente;

    @BeforeEach
    void setUP() {
        cliente = new ClienteRegistrado("password", "03344676R", false);
    }

    @Test
    public void test1() {
        IllegalArgumentException error = null;
        Participante p = null;
        
        try {
            p = new Participante(3, cliente);
        } catch (IllegalArgumentException e) {
            error = e;
            // Otro manejo de la excepción si es necesario
        }

        assertEquals(error.getMessage(), "Solo se pueden pedir 1 o 2 entradas.");
        assertEquals(p, null);
    }

    @Test
    public void test2() {
        IllegalArgumentException error = null;
        Participante p = null;
        
        try {
            p = new Participante(1, cliente);
        } catch (IllegalArgumentException e) {
            error = e;
            // Otro manejo de la excepción si es necesario
        }

        assertEquals(error, null);
        assert(p != null);
    }
}
