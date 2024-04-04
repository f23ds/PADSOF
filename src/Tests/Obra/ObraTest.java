package Tests.Obra;

import static org.junit.jupiter.api.Assertions.*;

import Exposicion.*;
import Obra.*;
import Sala.*;
import Utils.*;
import org.junit.jupiter.api.*;

public class ObraTest {

  private Obra o1, o2;
  private Exposicion expo_perm, expo_temp;

  @BeforeEach
  void setUp() {
    Dimensiones dim1 = new Dimensiones(10, 20, 2.3);
    Dimensiones dim2 = new Dimensiones(40, 30, 3.3);
    Temperatura t = new Temperatura(17, 23);
    Humedad h = new Humedad(60, 76);

    o1 =
      new Escultura(
        "Elogio de la luz xvi",
        "Eduardo Chillida",
        1971,
        false,
        "SEG018940",
        100000,
        "Obra escultural que fusiona la solidez del material con la presencia de la luz.",
        "Alabastro",
        new Dimensiones(19, 37, 30),
        null,
        null
      );

    o2 =
      new Pintura(
        "Mona Lisa",
        "Da Vinci",
        1503,
        true,
        null,
        100000,
        "Descr",
        "buena",
        new Dimensiones(0.6, 0.45, 0.4),
        t,
        h
      );

    SalaNoClimatizada s1 = new SalaNoClimatizada(45, 5, dim1);
    SalaClimatizada s2 = new SalaClimatizada(35, 4, dim2, t, h);

    expo_perm =
      new ExposicionPermanente(
        "EXPO1",
        "Ruperto",
        "Primera exposición",
        0.0,
        EstadoExposicion.EN_CREACION
      );

    expo_temp =
      new ExposicionTemporal(
        "EXPO2",
        "Ruperto2",
        "Segunda expo",
        0.0,
        EstadoExposicion.EN_CREACION,
        null,
        null
      );

    expo_perm.addSalas(s1, s2);
    expo_temp.addSalas(s1, s2);
  }

  @Test
  void testAlmacenar() {
    assertEquals(o1.retirar(), Status.OK);
    assertEquals(o1.getEstado(), EstadosObra.RETIRADA);
    assertEquals(o1.almacenar(), Status.ERROR);
    assertEquals(o2.prestar(), Status.OK);
    assertEquals(o2.getEstado(), EstadosObra.PRESTADA);
    assertEquals(o2.almacenar(), Status.OK);
    assertNull(o2.exposicion);
  }

  @Test
  void testExponer() {
    expo_perm.setEstado(EstadoExposicion.COMENZADA);
    assertTrue(o1.exponer(expo_perm) == Status.ERROR);
    expo_perm.setEstado(EstadoExposicion.EN_CREACION);
    assertTrue(o1.getEstado() == EstadosObra.ALMACEN);

    o2.setPropia(false);
    assertEquals(o2.exponer(expo_temp), Status.ERROR);

    assertTrue(o2.necesitaClimatizacion());
    assertEquals(o2.exponer(expo_perm), Status.OK);
    assertTrue(expo_perm.getObras().contains(o2));
    assertEquals(o1.exponer(expo_perm), Status.ERROR);
  }

  @Test
  void testRestaurar() {
    assertEquals(o1.getEstado(), EstadosObra.ALMACEN);
    assertEquals(o1.isPropia(), false);
    assertTrue(o1.restaurar() == Status.ERROR);
    assertEquals(o2.getEstado(), EstadosObra.ALMACEN);
    assertEquals(o2.isPropia(), true);
    assertTrue(o2.restaurar() == Status.OK);
  }

  @Test
  void testPrestar() {
    assertTrue(o1.prestar() == Status.OK);
    assertEquals(o1.getEstado(), EstadosObra.PRESTADA);
    assertEquals(o2.restaurar(), Status.OK);
    o2.setPropia(false);
    assertFalse(o2.prestar() == Status.OK);
  }

  @Test
  void testRetirar() {
    assertTrue(o1.prestar() == Status.OK);
    assertTrue(o1.retirar() == Status.ERROR);
    assertTrue(o2.retirar() == Status.OK);
    assertNull(o2.exposicion);
  }
}
