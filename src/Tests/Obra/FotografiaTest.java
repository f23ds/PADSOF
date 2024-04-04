package Tests.Obra;

import static org.junit.jupiter.api.Assertions.*;

import Exposicion.TipoDeObra;
import Obra.*;
import Utils.Dimensiones;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FotografiaTest {

  private Fotografia f;

  @BeforeEach
  void setUP() {
    f =
      new Fotografia(
        "Elogio de la luz xvi",
        "Eduardo Chillida",
        1971,
        true,
        "SEG018940",
        100000,
        "Obra escultural que fusiona la solidez del material con la presencia de la luz.",
        TipoFotografia.BYN,
        new Dimensiones(19, 37, 30),
        null,
        null
      );
  }

  @Test
  void testCargarFotografiaDeFichero() {
    String obra =
      "FOTOGRAFIA;CENTRO;Muerte de un miliciano;Robert Cappa;1936;Fotografia tomada en la localidad andaluza de Espejo, el 5 de septiembre de 1936, que muestra un soldado republicano que cae mientras una de sus manos sostiene un arma.;1000;SEG214448;;;Blanco y negro;;;31.8;45.4;;;";

    Fotografia es_aux = Fotografia.cargarFotografiaDeFichero(
      obra.split(";", -1)
    );

    assertEquals(es_aux.getTipo(), TipoFotografia.BYN);

    assert (es_aux.getTipoObra() == TipoDeObra.FOTOGRAFIA);
  }

  @Test
  void testGetTipo() {
    assertEquals(f.getTipo(), TipoFotografia.BYN);
  }

  @Test
  void testGetTipoObra() {
    assert (f.getTipoObra() == TipoDeObra.FOTOGRAFIA);
  }

  @Test
  void testSetTipo() {
    f.setTipo(TipoFotografia.COLOR);
    assertEquals(f.getTipo(), TipoFotografia.COLOR);
  }
}
