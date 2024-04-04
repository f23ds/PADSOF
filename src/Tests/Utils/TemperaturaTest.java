package Tests.Utils;

import static org.junit.jupiter.api.Assertions.*;

import Utils.*;
import org.junit.jupiter.api.*;

public class TemperaturaTest {

    private Temperatura h1, h2, h3, h4;

    @BeforeEach
    void setUp() {
        h1 = new Temperatura(10, 15);
        h2 = new Temperatura(5, 10);
        h3 = null;
        h4 = new Temperatura(11, 14);
    }

    @Test
    void testCheckTemperatura() {
        assertFalse(h1.checkTemperatura(h2));
        assertFalse(h2.checkTemperatura(h1));
        assertFalse(h1.checkTemperatura(h3));
        assertTrue(h4.checkTemperatura(h1));
    }
}