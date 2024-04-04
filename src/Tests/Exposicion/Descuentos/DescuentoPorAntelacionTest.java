package Tests.Exposicion.Descuentos;

import static org.junit.jupiter.api.Assertions.*;

import Exposicion.Descuento.DescuentoPorAntelacion;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DescuentoPorAntelacionTest {

  private DescuentoPorAntelacion desc;

  @BeforeEach
  void setUp() {
    desc = new DescuentoPorAntelacion(0.3, 2);
    assertNotNull(desc); // Asegura que desc no es null usando JUnit 5
  }

  @Test
  void testCheckDescuentoPorAntelacion() {
    assertTrue(desc.checkDescuentoPorAntelacion(LocalDate.of(2024, 2, 1)));
    assertFalse(desc.checkDescuentoPorAntelacion(LocalDate.of(2024, 3, 1)));
  }
}
