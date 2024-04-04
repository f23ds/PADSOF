package Tests.Exposicion;

import static org.junit.jupiter.api.Assertions.*;

import Entrada.Entrada;
import Exposicion.*;
import Utils.*;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.*;

public class ExposicionTemporalTest {

  private ExposicionTemporal expo;

  @BeforeEach
  void setUp() {
    expo =
      new ExposicionTemporal(
        "EXPO1",
        "Ruperto",
        "Primera expo",
        20,
        EstadoExposicion.EN_CREACION,
        LocalDate.of(2024, 01, 1),
        LocalDate.of(2024, 03, 03)
      );

    Entrada e1 = new Entrada(
      8,
      20,
      LocalDate.of(2024, 1, 23),
      LocalDate.of(2024, 02, 4),
      LocalTime.of(10, 30)
    );
    Entrada e2 = new Entrada(
      10,
      20,
      LocalDate.of(2024, 2, 12),
      LocalDate.of(2024, 02, 4),
      LocalTime.of(10, 45)
    );
    Entrada e3 = new Entrada(
      5,
      20,
      LocalDate.of(2023, 10, 17),
      LocalDate.of(2024, 02, 4),
      LocalTime.of(10, 45)
    );

    expo.addEntradas(e1, e2, e3);

    assert (expo != null);
  }

  @Test
  void testProrrogar() {
    assertTrue(expo.prorrogar(LocalDate.now()) == Status.ERROR);
    expo.setEstado(EstadoExposicion.COMENZADA);
    assertTrue(expo.prorrogar(LocalDate.now()) == Status.OK);
  }

  @Test
  void testCancelar() {
    assertTrue(expo.cancelar() == Status.ERROR);
    expo.setEstado(EstadoExposicion.COMENZADA);
    assertTrue(expo.cancelar() == Status.OK); 
  }
}
