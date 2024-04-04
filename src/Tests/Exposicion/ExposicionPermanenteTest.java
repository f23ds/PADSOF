package Tests.Exposicion;

import static org.junit.jupiter.api.Assertions.*;

import Exposicion.*;
import Utils.*;
import java.time.LocalDate;
import org.junit.jupiter.api.*;

public class ExposicionPermanenteTest {

  private ExposicionPermanente expo;

  @BeforeEach
  void setUp() {
    expo =
      new ExposicionPermanente(
        "EXPO1",
        "Ruperto",
        "Primera exposición",
        20,
        EstadoExposicion.EN_CREACION
      );

    assert (expo != null);
  }

  @Test
  void testCancelar() {
    assertTrue(expo.cancelar() == Status.OK);
    assertTrue(expo.cancelar() == Status.ERROR);
  }

  @Test
  void testInterrumpir() {
    expo.interrumpir(LocalDate.of(2024, 3, 3), LocalDate.of(2024, 4, 3));
    assertNotNull(expo.getfFinal());
    assertNotNull(expo.getfInicio());
  }
}
