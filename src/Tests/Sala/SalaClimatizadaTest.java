package Tests.Sala;

import Utils.*;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import Sala.Sala;
import Sala.SalaClimatizada;

/**
 * Tester para el metodo dividirSala en la clase sala climatizada
 * 
 * @author Victor Sanz
 */
public class SalaClimatizadaTest {
  private SalaClimatizada sala;
  @BeforeEach
  void setUp() {
    Dimensiones dim = new Dimensiones(20, 20, 10);
    Temperatura t = new Temperatura(22, 39);
    Humedad h = new Humedad(45, 72);
    sala = new SalaClimatizada(61, 9, dim, t, h);
  
    assert(sala != null);
    
  }

  @Test
  public void testDividirSala() {
    Dimensiones dim1 = new Dimensiones(11.5f, 20, 10);
    Dimensiones dim2 = new Dimensiones(8.5f, 20, 10);

    Temperatura t1 = new Temperatura(17, 23);
    Humedad h1 = new Humedad(60, 76);
    Temperatura t2 = new Temperatura(23, 30);
    Humedad h2 = new Humedad(50, 72);

    SalaClimatizada s1 = new SalaClimatizada(26, 5, dim1, t1, h1);
    SalaClimatizada s2 = new SalaClimatizada(35, 4, dim2, t2, h2);

    

    ArrayList<Sala> arraySalas = new ArrayList<Sala>();
    arraySalas.add(s1);
    arraySalas.add(s2);

    sala.dividirSala(11.5f,8.5f,26, 35, 5, 4, t1, t2, h1, h2);

    System.out.println(arraySalas.get(0).getAforo());

    Sala subsala1 = sala.getSubsala1();
    Sala subsala2 = sala.getSubsala2();


    assertTrue(subsala1.getAforo() == arraySalas.get(0).getAforo());
    assertTrue(subsala2.getAforo() == arraySalas.get(1).getAforo());
    assertTrue(subsala1.getTomasCorriente() == arraySalas.get(0).getTomasCorriente());
    assertTrue(subsala2.getTomasCorriente() == arraySalas.get(1).getTomasCorriente());
    assertTrue(subsala1.getDimensiones().getAncho() == arraySalas.get(0).getDimensiones().getAncho());
    assertTrue(subsala2.getDimensiones().getAncho() == arraySalas.get(1).getDimensiones().getAncho());
    assertEquals(subsala1.getTemperatura(), arraySalas.get(0).getTemperatura());
    assertEquals(subsala2.getTemperatura(), arraySalas.get(1).getTemperatura());
    assertEquals(subsala1.getHumedad(), arraySalas.get(0).getHumedad());
    assertEquals(subsala2.getHumedad(), arraySalas.get(1).getHumedad());
  }

  @Test
  public void testError() {
    Temperatura t1 = new Temperatura(17, 23);
    Humedad h1 = new Humedad(60, 76);
    Temperatura t2 = new Temperatura(23, 30);
    Humedad h2 = new Humedad(50, 72);
    Status status;
    status = sala.dividirSala(11.5f, 10, 26, 35, 5, 4, t1, t2, h1, h2);

    assertEquals(status, Status.ERROR);
  }
}