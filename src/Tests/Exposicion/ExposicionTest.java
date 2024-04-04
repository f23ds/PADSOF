package Tests.Exposicion;

import static org.junit.jupiter.api.Assertions.*;

import Entrada.*;
import Exposicion.*;
import Exposicion.Descuento.*;
import Obra.*;
import Sala.*;
import Usuario.ClienteRegistrado;
import Utils.*;
import java.time.*;
import java.util.*;
import org.junit.jupiter.api.*;
import Sorteo.*;

public class ExposicionTest {

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
  void testAddSalas() {
    Dimensiones dim1 = new Dimensiones(10, 20, 2.3f);
    Dimensiones dim2 = new Dimensiones(8.5f, 23.3f, 2.3f);
    Temperatura t = new Temperatura(17, 23);
    Humedad h = new Humedad(60, 76);

    SalaNoClimatizada s1 = new SalaNoClimatizada(45, 5, dim1);
    SalaClimatizada s2 = new SalaClimatizada(35, 4, dim2, t, h);

    List<Sala> arraySalas = new ArrayList<Sala>();
    arraySalas.add(s1);
    arraySalas.add(s2);

    expo.addSalas(s1, s2);

    assertEquals(expo.getSalas(), arraySalas);
  }

  @Test
  void testAddSalasNull() {
    Dimensiones dim1 = new Dimensiones(10, 20, 2.3f);
    Dimensiones dim2 = new Dimensiones(8.5f, 23.3f, 2.3f);
    Temperatura t = new Temperatura(17, 23);
    Humedad h = new Humedad(60, 76);

    SalaNoClimatizada s1 = new SalaNoClimatizada(45, 5, dim1);
    SalaClimatizada s2 = new SalaClimatizada(35, 4, dim2, t, h);

    List<Sala> arraySalas = new ArrayList<Sala>();
    arraySalas.add(s1);
    arraySalas.add(s2);
    arraySalas.add(null);

    expo.addSalas(s1, s2, null);

    assertNotEquals(expo.getSalas(), arraySalas);
  }

  @Test
  void testAddObras() {
    Fotografia foto = new Fotografia(
      null,
      null,
      0,
      false,
      null,
      0,
      null,
      null,
      0,
      0,
      0,
      0,
      0,
      0,
      0
    );
    Pintura pintura = new Pintura(
      null,
      null,
      0,
      false,
      null,
      0,
      null,
      null,
      null,
      null,
      null
    );

    List<Obra> obras = new ArrayList<Obra>();
    obras.add(foto);
    obras.add(pintura);

    expo.addObras(foto, pintura);

    assertEquals(expo.getObras(), obras);
  }

  @Test
  void testAddObrasNull() {
    Fotografia foto = new Fotografia(
      null,
      null,
      0,
      false,
      null,
      0,
      null,
      null,
      0,
      0,
      0,
      0,
      0,
      0,
      0
    );
    Pintura pintura = new Pintura(
      null,
      null,
      0,
      false,
      null,
      0,
      null,
      null,
      null,
      null,
      null
    );

    List<Obra> obras = new ArrayList<Obra>();
    obras.add(foto);
    obras.add(pintura);
    obras.add(null);

    expo.addObras(foto, pintura, null);

    assertNotEquals(expo.getObras(), obras);
  }

  @Test
  void testRemoveObras() {
    Fotografia foto = new Fotografia(
      null,
      null,
      0,
      false,
      null,
      0,
      null,
      null,
      0,
      0,
      0,
      0,
      0,
      0,
      0
    );
    Pintura pintura = new Pintura(
      null,
      null,
      0,
      false,
      null,
      0,
      null,
      null,
      null,
      null,
      null
    );
    Escultura escultura = new Escultura(
      null,
      null,
      0,
      false,
      null,
      0,
      null,
      null,
      null,
      null,
      null
    );

    expo.addObras(foto, pintura, escultura);

    expo.removeObras(foto, pintura);

    assertEquals(expo.getObras(), Arrays.asList(escultura));
  }

  @Test
  void testTieneObraDeTipo() {
    Fotografia foto = new Fotografia(
      null,
      null,
      0,
      false,
      null,
      0,
      null,
      null,
      0,
      0,
      0,
      0,
      0,
      0,
      0
    );

    expo.addObras(foto);

    assertTrue(expo.tieneObraDeTipo(TipoDeObra.FOTOGRAFIA));
    assertFalse(expo.tieneObraDeTipo(TipoDeObra.ESCULTURA));
  }

  @Test
  void testAddDescuento() {
    DescuentoPorCompra descPorCompra = new DescuentoPorCompra(0.3, 5);

    expo.addDescuento(descPorCompra);

    assertEquals(descPorCompra, expo.getDescuentos().get(0));
    assertEquals(null, expo.getDescuentos().get(1));

    DescuentoPorAntelacion descPorAnte = new DescuentoPorAntelacion(0.4, 6);

    assertTrue(expo.addDescuento(descPorAnte) == Status.OK);

    assertEquals(descPorAnte, expo.getDescuentos().get(1));

    assertTrue(expo.addDescuento(descPorAnte) == Status.ERROR);
  }

  @Test
  void testRemoveDescuento() {
    testAddDescuento();

    expo.quitarDescuento(false);
    expo.quitarDescuento(true);

    assertNull(expo.getDescuentos().get(0));
    assertNull(expo.getDescuentos().get(1));
  }

  @Test
  void testAddEntradas() {
    Entrada e1 = new Entrada(8, 20, LocalDate.of(2024, 1, 23), LocalDate.of(2024, 04, 3), LocalTime.of(10, 30));
    Entrada e2 = new Entrada(10, 20, LocalDate.of(2024, 2, 12), LocalDate.of(2024, 04, 4), LocalTime.of(10, 45));
    Entrada e3 = new Entrada(5, 20, LocalDate.of(2023, 10, 17), LocalDate.of(2024, 04, 4), LocalTime.of(10, 45));

    List<Entrada> entradasList = new ArrayList<Entrada>();
    entradasList.add(e1);
    entradasList.add(e2);
    entradasList.add(e3);

    expo.addEntradas(e1, e2, e3);

    assertEquals(expo.getEntradas(), entradasList);
  }

  @Test
  void testAddEntradasNull() {
    Entrada e1 = new Entrada(8, 20, LocalDate.of(2024, 1, 23), LocalDate.of(2024, 04, 3), LocalTime.of(10, 30));
    Entrada e2 = new Entrada(10, 20, LocalDate.of(2024, 2, 12), LocalDate.of(2024, 04, 4), LocalTime.of(10, 45));
    Entrada e3 = new Entrada(5, 20, LocalDate.of(2023, 10, 17), LocalDate.of(2024, 04, 4), LocalTime.of(10, 45));

    List<Entrada> entradasList = new ArrayList<Entrada>();
    entradasList.add(e1);
    entradasList.add(e2);
    entradasList.add(e3);

    expo.addEntradas(e1, e2, e3, null, null, null);

    assertEquals(expo.getEntradas(), entradasList);
  }

  @Test
  void testGetDineroRecaudado() {
    testAddEntradas();

    assertEquals(60, expo.getDineroRecaudado(LocalDate.of(2023, 10, 15), LocalDate.now()));
    assertEquals(40, expo.getDineroRecaudado(LocalDate.of(2024, 01, 1), LocalDate.now()));
    assertEquals(0, expo.getDineroRecaudado(LocalDate.of(2024, 02, 13), LocalDate.now()));
  }

  @Test
  void testCheckEstadoExposicion() {
    ExposicionPermanente exp_permanente = new ExposicionPermanente(
      "EXPO1",
      "Ruperto",
      "Primera exposición",
      20,
      EstadoExposicion.EN_CREACION
    );

    assert(exp_permanente.publicar() == Status.OK);

    assert(exp_permanente.getEstado() == EstadoExposicion.DISPONIBLE);

    exp_permanente.interrumpir(LocalDate.now(), LocalDate.now().plusWeeks(1));

    exp_permanente.checkEstadoExposicion();

    assert(exp_permanente.getEstado() == EstadoExposicion.INTERRUMPIDA);

    exp_permanente = new ExposicionPermanente(
      "EXPO1",
      "Ruperto",
      "Primera exposición",
      20,
      EstadoExposicion.INTERRUMPIDA
    );

    exp_permanente.interrumpir(LocalDate.of(2023, 1, 1), LocalDate.now());

    exp_permanente.checkEstadoExposicion();

    assert(exp_permanente.getEstado() == EstadoExposicion.DISPONIBLE);

    ExposicionTemporal exp_temporal = new ExposicionTemporal(
      "EXPO1",
      "Ruperto",
      "Primera expo",
      20,
      EstadoExposicion.EN_CREACION,
      LocalDate.now(),
      LocalDate.of(2025, 07, 03)
    );

    assert(exp_temporal.publicar() == Status.OK);

    assert(exp_temporal.getEstado() == EstadoExposicion.DISPONIBLE);

    exp_temporal.checkEstadoExposicion();

    assert(exp_temporal.getEstado() == EstadoExposicion.COMENZADA);

    exp_temporal = new ExposicionTemporal(
      "EXPO1",
      "Ruperto",
      "Primera expo",
      20,
      EstadoExposicion.COMENZADA,
      LocalDate.of(2024, 1, 1),
      LocalDate.now()
    );

    exp_temporal.checkEstadoExposicion();

    assert(exp_temporal.getEstado() == EstadoExposicion.TERMINADA);

    exp_temporal = new ExposicionTemporal(
      "EXPO1",
      "Ruperto",
      "Primera expo",
      20,
      EstadoExposicion.COMENZADA,
      LocalDate.of(2024, 1, 1),
      LocalDate.of(2025, 1, 1)
    );

    exp_temporal.cancelar();

    /*La cancelacion se hace efectiva tras una semana, así que simulamos que se cancela hoy */
    exp_temporal.setfFinal(LocalDate.now());

    exp_temporal.checkEstadoExposicion();

    assert(exp_temporal.getEstado() == EstadoExposicion.CANCELADA);
  }

  @Test
  void testComprarEntrada1() {
    ClienteRegistrado cliente = new ClienteRegistrado("password", "03344676R", false);
    Dimensiones dim = new Dimensiones(20, 20, 10);
    Sala sala = new SalaNoClimatizada(2, 9, dim);
    expo.publicar();
    expo.addSalas(sala);
    assert(expo.comprarEntrada(cliente, 2, LocalDate.of(2024, 07, 13), LocalTime.of(10,0,0), "123456789012345") == Status.ERROR);
    assert(expo.comprarEntrada(cliente, 2, LocalDate.of(2024, 07, 13), LocalTime.of(10,0,0), "1234567890123456") == Status.OK);
    assert(expo.comprarEntrada(cliente, 2, LocalDate.of(2024, 07, 13), LocalTime.of(10,0,0), "1234567890123456") == Status.ERROR);

    expo.interrumpir(LocalDate.now(), LocalDate.now().plusWeeks(1));

    expo.checkEstadoExposicion();

    Sala sala2 = new SalaNoClimatizada(2, 9, dim);
    expo.addSalas(sala2);

    assert(expo.comprarEntrada(cliente, 2, LocalDate.of(2024, 07, 13), LocalTime.of(10,0,0), "1234567890123456") == Status.ERROR);

    ExposicionTemporal exp_temporal = new ExposicionTemporal(
      "EXPO1",
      "Ruperto",
      "Primera expo",
      20,
      EstadoExposicion.COMENZADA,
      LocalDate.of(2024, 1, 1),
      LocalDate.now()
    );

    assert(exp_temporal.comprarEntrada(cliente, 2, LocalDate.of(2024, 07, 13), LocalTime.of(10,0,0), "1234567890123456") == Status.ERROR);
 
  }

  @Test
  void testComprarEntrada2() {
    Sorteo s = new SorteoMientrasDureExp(20, LocalDate.of(2020, 1, 1), LocalDate.of(2020, 12, 31));
    UUID codigo = UUID.randomUUID();
    s.getCodigos().add(codigo);
    UUID codigo2 = UUID.randomUUID();
    s.getCodigos().add(codigo2);
    ClienteRegistrado cliente = new ClienteRegistrado("password", "03344676R", false);
    Dimensiones dim = new Dimensiones(20, 20, 10);
    Sala sala = new SalaNoClimatizada(1, 9, dim);
    expo.publicar();
    expo.addSalas(sala);

    expo.setSorteo(s);

    assert(expo.comprarEntrada(cliente, 1, LocalDate.now(), LocalTime.of(10,0,0), "1234567890123456", codigo.toString()) == Status.OK);
    assert(expo.comprarEntrada(cliente, 1, LocalDate.now(), LocalTime.of(10,0,0), "1234567890123456", codigo2.toString()) == Status.ERROR);

    Sala sala2 = new SalaNoClimatizada(4, 9, dim);
    expo.addSalas(sala2);

    assert(expo.comprarEntrada(cliente, 1, LocalDate.now(), LocalTime.of(10,0,0), "1234567890123456", UUID.randomUUID().toString()) == Status.ERROR);
    assert(expo.comprarEntrada(cliente, 1, LocalDate.now(), LocalTime.of(10,0,0), "1234567890123456", UUID.randomUUID().toString()) == Status.ERROR);

    expo.interrumpir(LocalDate.now(), LocalDate.now().plusWeeks(1));

    expo.checkEstadoExposicion();

    assert(expo.comprarEntrada(cliente, 2, LocalDate.of(2024, 07, 13), LocalTime.of(10,0,0), "1234567890123456", codigo.toString()) == Status.ERROR);

    ExposicionTemporal exp_temporal = new ExposicionTemporal(
      "EXPO1",
      "Ruperto",
      "Primera expo",
      20,
      EstadoExposicion.COMENZADA,
      LocalDate.of(2024, 1, 1),
      LocalDate.now()
    );

    assert(exp_temporal.comprarEntrada(cliente, 2, LocalDate.of(2024, 07, 13), LocalTime.of(10,0,0), "1234567890123456", codigo.toString()) == Status.ERROR);
  }

  @Test 
  void testVenderEntrada() {
    
    Dimensiones dim = new Dimensiones(20, 20, 10);
    Sala sala = new SalaNoClimatizada(2, 9, dim);
    expo.publicar();
    expo.addSalas(sala);
    assert(expo.venderEntrada(2, LocalTime.of(10,0,0), "123456789012345") == Status.ERROR);
    assert(expo.venderEntrada(2, LocalTime.of(10,0,0), "1234567890123456") == Status.OK);
    assert(expo.venderEntrada(2, LocalTime.of(10,0,0), "1234567890123456") == Status.ERROR);

    Sala sala2 = new SalaNoClimatizada(4, 9, dim);
    expo.addSalas(sala2);

    expo.interrumpir(LocalDate.now(), LocalDate.now().plusWeeks(1));

    expo.checkEstadoExposicion();

    assert(expo.venderEntrada(2, LocalTime.of(10,0,0), "1234567890123456") == Status.ERROR);

    ExposicionTemporal exp_temporal = new ExposicionTemporal(
      "EXPO1",
      "Ruperto",
      "Primera expo",
      20,
      EstadoExposicion.COMENZADA,
      LocalDate.of(2024, 1, 1),
      LocalDate.now().plusWeeks(1)
    );

    exp_temporal.addSalas(sala, sala2);

    assert(exp_temporal.venderEntrada(2, LocalTime.of(10,0,0), "1234567890123456") == Status.OK);

    exp_temporal.setfFinal(LocalDate.now());
    exp_temporal.checkEstadoExposicion();

    assert(exp_temporal.venderEntrada(2, LocalTime.of(10,0,0), "1234567890123456") == Status.ERROR);
  }

  @Test 
  void testGetEntradasPorHora() {
    testAddEntradas();

    assertEquals(0, expo.getEntradasPorHora(LocalDate.of(2024, 04, 03), LocalTime.of(10, 35)));
    assertEquals(8, expo.getEntradasPorHora(LocalDate.of(2024, 04, 03), LocalTime.of(10, 30)));
    assertEquals(15, expo.getEntradasPorHora(LocalDate.of(2024, 04, 04), LocalTime.of(10, 45)));
  }

  @Test
  void testPublicar() {
    assertTrue(expo.publicar() == Status.OK);
    assertTrue(expo.publicar() == Status.ERROR);
  }
}
