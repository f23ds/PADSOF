package Tests.Sala;

import static org.junit.Assert.*;

import Sala.*;
import Utils.*;
import org.junit.Test;

/**
 * Tester para el metodo dividirSala en el caso de error
 * @author Victor Sanz
 */
public class SalaErrorTest {

  @Test
  public void testAddSalas() {
    Dimensiones dim = new Dimensiones(20, 20, 10);
    SalaNoClimatizada sala = new SalaNoClimatizada(61, 9, dim);
    Status status;
    status = sala.dividirSala(11.5f, 10, 26, 35, 5, 4);

    assertEquals(status, Status.ERROR);
  }
}
