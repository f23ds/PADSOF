package Tests.Exposicion.Descuentos;

import static org.junit.jupiter.api.Assertions.*;

import Entrada.Comprada;
import Exposicion.Descuento.DescuentoPorCompra;
import Usuario.ClienteRegistrado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DescuentoPorCompraTest {

  private DescuentoPorCompra desc;

  @BeforeEach
  void setUp() {
    desc = new DescuentoPorCompra(0.3, 10);
    assertNotNull(desc); // Asegura que desc no es null usando JUnit 5
  }

  @Test
  void testCheckDescuentoPorCompra() {
    ClienteRegistrado cliente = new ClienteRegistrado(
      "xyz123",
      "54190423T",
      false
    );
    Comprada entradaComprada = new Comprada(
      10,
      20,
      null,
      null,
      null,
      null,
      cliente
    );

    cliente.addEntradas(entradaComprada);

    assertTrue(desc.checkDescuentoPorCompra(cliente));
  }
}
