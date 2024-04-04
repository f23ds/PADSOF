package Tests.Sala;

import static org.junit.Assert.*;

import Sala.Sala;
import Sala.SalaNoClimatizada;
import Utils.*;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tester para el metodo dividirSala en la clase sala no climatizada
 *
 * @author Victor Sanz
 */
public class SalaNoClimatizadaTest {

  private SalaNoClimatizada sala;

  @BeforeEach
  void setUp() {
    Dimensiones dim = new Dimensiones(20, 20, 10);
    sala = new SalaNoClimatizada(61, 9, dim);

    assert (sala != null);
  }

  @Test
  public void testDividiarSala() {
    Dimensiones dim1 = new Dimensiones(11.5f, 20, 10);
    Dimensiones dim2 = new Dimensiones(8.5f, 20, 10);

    SalaNoClimatizada s1 = new SalaNoClimatizada(26, 5, dim1);
    SalaNoClimatizada s2 = new SalaNoClimatizada(35, 4, dim2);

    ArrayList<Sala> arraySalas = new ArrayList<Sala>();
    arraySalas.add(s1);
    arraySalas.add(s2);

    sala.dividirSala(11.5f, 8.5f, 26, 35, 5, 4);

    Sala subsala1 = sala.getSubsala1();
    Sala subsala2 = sala.getSubsala2();

    assertTrue(subsala1.getAforo() == arraySalas.get(0).getAforo());
    assertTrue(subsala2.getAforo() == arraySalas.get(1).getAforo());
    assertTrue(
      subsala1.getTomasCorriente() == arraySalas.get(0).getTomasCorriente()
    );
    assertTrue(
      subsala2.getTomasCorriente() == arraySalas.get(1).getTomasCorriente()
    );
    assertTrue(
      subsala1.getDimensiones().getAncho() ==
      arraySalas.get(0).getDimensiones().getAncho()
    );
    assertTrue(
      subsala2.getDimensiones().getAncho() ==
      arraySalas.get(1).getDimensiones().getAncho()
    );
  }

  @Test
  public void testError() {
    Status status;
    status = sala.dividirSala(11.5f, 10, 26, 35, 5, 4);

    assertEquals(status, Status.ERROR);
  }
}
