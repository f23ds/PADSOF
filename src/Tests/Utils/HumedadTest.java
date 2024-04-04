package Tests.Utils;

import static org.junit.jupiter.api.Assertions.*;

import Utils.*;
import org.junit.jupiter.api.*;

public class HumedadTest {

    private Humedad h1, h2, h3, h4;

    @BeforeEach
    void setUp() {
        h1 = new Humedad(10, 15);
        h2 = new Humedad(5, 10);
        h3 = null;
        h4 = new Humedad(11, 14);
    }

    @Test
    void testCheckHumedad() {
        assertFalse(h1.checkHumedad(h2));
        assertFalse(h2.checkHumedad(h1));
        assertFalse(h1.checkHumedad(h3));
        assertTrue(h4.checkHumedad(h1));
    }
}