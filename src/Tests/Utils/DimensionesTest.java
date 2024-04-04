package Tests.Utils;

import static org.junit.jupiter.api.Assertions.*;

import Utils.*;
import org.junit.jupiter.api.*;

public class DimensionesTest {

    private Dimensiones d1, d2;

    @BeforeEach
    void setUp() {
        d1 = new Dimensiones(10, 10, 10);
        d2 = new Dimensiones(5,5,5);
    }

    @Test
    void testCheckDimensiones() {
        assertTrue(d1.checkDimensiones(d2));
        assertFalse(d2.checkDimensiones(d1));
    }
}