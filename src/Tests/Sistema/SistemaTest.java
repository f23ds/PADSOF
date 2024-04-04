package Tests.Sistema;

import Utils.*;
import Usuario.*;
import Obra.*;
import Sala.SalaClimatizada;
import Sala.SalaNoClimatizada;
import Entrada.*;
import Exposicion.*;
import Sistema.*;
import Sorteo.*;

import static org.junit.Assert.*;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


/**
 * Tester para el metodo dividirSala en la clase sala climatizada
 * 
 * @author Victor Sanz
 */
public class SistemaTest {
  private Sistema sistema;

  @BeforeEach
  void setUp() {
    Sistema.setInstanceNull();
    sistema = Sistema.getInstance();

  }

  @Test
  void testloginCliente() {
    ClienteRegistrado c = new ClienteRegistrado("holamundo", "47000001A", false);
    
    sistema.addClientes(c);

    assertEquals(c, sistema.loginCliente("47000001A", "holamundo"));
  }

  @Test
  void testloginClientenull() {
    ClienteRegistrado c = new ClienteRegistrado("holamundo", "00000001A", false);
    
    sistema.addClientes(c);

    assertEquals(null, sistema.loginCliente("00000001A", "holaaaaa"));
  }

  @Test
  void testloginEmpleado() {
    Empleado e = new Empleado("empleado2024", "49012982L", "Paseo de los Historiadores", 3253425, 6243532, true, true, true);
    
    sistema.addEmpleados(e);

    assertEquals(e, sistema.loginEmpleado("49012982L", "empleado2024"));
  }

  @Test
  void testloginEmpleadonull() {

    assertEquals(null, sistema.loginEmpleado("49012982L", "pedrito34"));
  }

  @Test
  void testloginGestor() {
    Gestor g = sistema.getGestor();

    assertEquals(g, sistema.loginGestor("JefeAlberto", "Password123"));
  }

  @Test
  void testloginGestornull() {

    assertEquals(null, sistema.loginEmpleado("JefeAlberto", "Wrongpasswd"));
  }

  @Test
  void testcerrarsesion(){
    ClienteRegistrado c1 = new ClienteRegistrado("holamundo", "00000001A", false);
    sistema.setUsuarioActivo(c1);

    sistema.cerrarSesion();

    assertEquals(null, sistema.getUsuarioActivo());
  }

  @Test
  void testbuscarPorPermanente(){
    Exposicion exp1 = new ExposicionPermanente("La cueva del oso", "Federico Martin", "Una exposicion llena de belleza", 10, EstadoExposicion.DISPONIBLE);
    Exposicion exp2 = new ExposicionPermanente("La risa de las aves", "Francisco Lozoya", "Obras pintorescas y graciosas", 9, EstadoExposicion.INTERRUMPIDA);
    Exposicion exp3 = new ExposicionTemporal("El suspiro de la muerte", "Pablo Sanchez", "Dramatismo y horror", 12, EstadoExposicion.COMENZADA, LocalDate.of(2024, 3, 10), LocalDate.of(2024, 4, 10));

    Collection<Exposicion> permanentes = new ArrayList<Exposicion>();

    permanentes.add(exp1);
    permanentes.add(exp2);
    /*Exposicion exp4 = new ExposicionTemporal("Goya y sus caprichos", "Pedro Valentin", "Las obras menos conocidas de Goya", 12, EstadoExposicion.DISPONIBLE, LocalDate.of(2024, 4, 10), LocalDate.of(2024, 4, 28));*/
    sistema.addExposiciones(exp1, exp2, exp3);

    assertEquals(permanentes, sistema.buscarPorPermanente());

  }

  @Test
  void testbuscarPorTemporal(){
    Exposicion exp1 = new ExposicionPermanente("La cueva del oso", "Federico Martin", "Una exposicion llena de belleza", 10, EstadoExposicion.DISPONIBLE);
    Exposicion exp2 = new ExposicionPermanente("La risa de las aves", "Francisco Lozoya", "Obras pintorescas y graciosas", 9, EstadoExposicion.INTERRUMPIDA);
    Exposicion exp3 = new ExposicionTemporal("El suspiro de la muerte", "Pablo Sanchez", "Dramatismo y horror", 12, EstadoExposicion.COMENZADA, LocalDate.of(2024, 3, 10), LocalDate.of(2024, 4, 10));
    Exposicion exp4 = new ExposicionTemporal("Goya y sus caprichos", "Pedro Valentin", "Las obras menos conocidas de Goya", 12, EstadoExposicion.DISPONIBLE, LocalDate.of(2024, 4, 10), LocalDate.of(2024, 4, 28));

    Collection<Exposicion> temporales = new ArrayList<Exposicion>();

    temporales.add(exp3);
    temporales.add(exp4);
    /*Exposicion exp4 = new ExposicionTemporal("Goya y sus caprichos", "Pedro Valentin", "Las obras menos conocidas de Goya", 12, EstadoExposicion.DISPONIBLE, LocalDate.of(2024, 4, 10), LocalDate.of(2024, 4, 28));*/
    sistema.addExposiciones(exp1, exp2, exp3, exp4);

    assertEquals(temporales, sistema.buscarPorTemporal());

  }

  @Test
  void testbuscarPorTipo(){
    Exposicion exp1 = new ExposicionPermanente("La cueva del oso", "Federico Martin", "Una exposicion llena de belleza", 10, EstadoExposicion.EN_CREACION);
    Exposicion exp2 = new ExposicionPermanente("La risa de las aves", "Francisco Lozoya", "Obras pintorescas y graciosas", 9, EstadoExposicion.EN_CREACION);

    Dimensiones dim1 = new Dimensiones(10, 20, 2.3);
    SalaNoClimatizada s1 = new SalaNoClimatizada(45, 5, dim1);

    Dimensiones dim2 = new Dimensiones(8.5, 23.3, 2.3);
    Temperatura t = new Temperatura(17, 23);
    Humedad h = new Humedad(60, 76);
    SalaClimatizada s2 = new SalaClimatizada(35, 4, dim2, t, h);

   
    exp1.addSalas(s1);
    exp2.addSalas(s2);

    Dimensiones dim_escultura = new Dimensiones(1, 1, 1);
    Escultura escultura = new Escultura(null,null,0,false,null,0,null,null,dim_escultura,null, null);
    
    Fotografia foto = new Fotografia(null,null,0,false,null,0,null,null,1,1,1,0,30,0,100);
    
    escultura.exponer(exp1);
    foto.exponer(exp2);

    sistema.addSalas(s1, s2);
    sistema.addObras(escultura, foto);
    sistema.addExposiciones(exp1, exp2);

    List<Exposicion> tipo_escultura = new ArrayList<Exposicion>();

    tipo_escultura.add(exp1);

    assertEquals(tipo_escultura, sistema.buscarPorTipo(TipoDeObra.ESCULTURA));
  }

  @Test
  void testbuscarPorFecha(){
    Exposicion exp1 = new ExposicionPermanente("La risa de las aves", "Francisco Lozoya", "Obras pintorescas y graciosas", 9, EstadoExposicion.DISPONIBLE);
    Exposicion exp2 = new ExposicionTemporal("El suspiro de la muerte", "Pablo Sanchez", "Dramatismo y horror", 12, EstadoExposicion.COMENZADA, LocalDate.of(2024, 3, 10), LocalDate.of(2024, 4, 10));
    Exposicion exp3 = new ExposicionTemporal("Goya y sus caprichos", "Pedro Valentin", "Las obras menos conocidas de Goya", 12, EstadoExposicion.DISPONIBLE, LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 28));

    List<Exposicion> exp_fechas = new ArrayList<>();

    exp_fechas.add(exp1);
    exp_fechas.add(exp2);

    sistema.addExposiciones(exp1,exp2,exp3);

    assertEquals(exp_fechas, sistema.buscarPorFecha(LocalDate.of(2024,3,25), LocalDate.of(2024,4,5)));
  }

  @Test
  void testgetNumEntradasTotales(){
    ClienteRegistrado c1 = new ClienteRegistrado("malakito23", "20000000B", true);
    Entrada ent1 = new Entrada(1, 8, LocalDate.of(2024, 2, 24), LocalDate.of(2024, 3, 2), LocalTime.of(11, 30));
    Entrada ent2 = new Entrada(2, 16, LocalDate.of(2024, 2, 26), LocalDate.of(2024, 3, 4), LocalTime.of(11, 30));
    Entrada com1 = new Comprada(3, 19.5, LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 10), LocalTime.of(14, 15), "56715261", c1);
    sistema.addEntradas(ent1, ent2, com1);

    assert(3 == sistema.getNumEntradasTotales(LocalDate.of(2024, 2, 23), LocalDate.of(2024,2,29)));

    
  }

  @Test 
  void testgetDineroRecaudadoTotal(){
    ClienteRegistrado c1 = new ClienteRegistrado("malakito23", "20000000B", true);
    Entrada ent1 = new Entrada(1, 8, LocalDate.of(2024, 2, 24), LocalDate.of(2024, 3, 2), LocalTime.of(11, 30));
    Entrada ent2 = new Entrada(2, 16, LocalDate.of(2024, 2, 26), LocalDate.of(2024, 3, 4), LocalTime.of(11, 30));
    Entrada com1 = new Comprada(3, 19.5, LocalDate.of(2024, 3, 1), LocalDate.of(2024, 3, 10), LocalTime.of(14, 15), "56715261", c1);

    sistema.addEntradas(ent1, ent2, com1);

    assert(sistema.getDineroRecaudadoTotal(LocalDate.of(2024, 2, 23), LocalDate.of(2024,2,29)) == (8+16));
  }

  @Test
  void testenviarNotificacionSist(){
    ClienteRegistrado c1 = new ClienteRegistrado("holamundo", "00000001A", false);
    ClienteRegistrado c2 = new ClienteRegistrado("malakito23", "20000000B", true);

    sistema.addClientes(c1, c2);

    Notificacion noti = new Notificacion(null, "Hola, que tal?");

    sistema.enviarNotificacionSist(noti);

    Collection<Notificacion> notificaciones = new ArrayList<Notificacion>();

    assertEquals(c1.getNotificaciones(), notificaciones);

    notificaciones.add(noti);

    assertEquals(c2.getNotificaciones(), notificaciones);
  }

  @Test
  void testenviarNotificacionEmp(){
    ClienteRegistrado c1 = new ClienteRegistrado("holamundo", "00000001A", false);
    ClienteRegistrado c2 = new ClienteRegistrado("malakito23", "20000000B", true);
    sistema.addClientes(c1, c2);

    Empleado e1 = new Empleado("empleado2024", "00000000C", "Calle la Retuerta", 567282342, 67313719, true, true, true);
    sistema.addEmpleados(e1);

    Notificacion noti = new Notificacion(null, "Hola, que tal?");

    sistema.enviarNotificacionEmp(noti, e1);

    Collection<Notificacion> notificaciones = new ArrayList<Notificacion>();

    assertEquals(c1.getNotificaciones(), notificaciones);

    notificaciones.add(noti);

    assertEquals(c2.getNotificaciones(), notificaciones);

  }

  @Test
  void testenviarNotificacionEmpError(){
    ClienteRegistrado c1 = new ClienteRegistrado("holamundo", "00000001A", false);
    ClienteRegistrado c2 = new ClienteRegistrado("malakito23", "20000000B", true);
    sistema.addClientes(c1, c2);

    Empleado e1 = new Empleado("empleado2024", "00000000C", "Calle la Retuerta", 567282342, 67313719, false, true, true);
    sistema.addEmpleados(e1);

    Notificacion noti = new Notificacion(null, "Hola, que tal?");

    sistema.enviarNotificacionEmp(noti, e1);

    Collection<Notificacion> notificaciones = new ArrayList<Notificacion>();

    assertEquals(c1.getNotificaciones(), notificaciones);

    assertEquals(c2.getNotificaciones(), notificaciones);

  }

  @Test
  void testGuardarDatos() {
    /*Mini sistema creado*/ 
    ClienteRegistrado c1 = new ClienteRegistrado("holamundo", "00000001A", false);
    sistema.addClientes(c1);

    Empleado e1 = new Empleado("empleado2024", "00000000C", "Calle la Retuerta", 567282342, 67313719, true, true, true);
    sistema.addEmpleados(e1);
    Entrada ent1 = new Entrada(1, 10.5, LocalDate.of(2024, 2, 24), LocalDate.of(2024, 3, 2), LocalTime.of(11, 30));
    sistema.addEntradas(ent1);
    Exposicion exp1 = new ExposicionPermanente("La cueva del oso", "Federico Martin", "Una exposicion llena de belleza", 10, EstadoExposicion.DISPONIBLE);
    
    sistema.addExposiciones(exp1);
    
    Dimensiones dim1 = new Dimensiones(10, 20, 2.3f);
    SalaNoClimatizada s1 = new SalaNoClimatizada(45, 5, dim1);

    sistema.addSalas(s1);
    exp1.addSalas(s1);
    

    Dimensiones dim_escultura = new Dimensiones(1, 1, 1);
    Escultura escultura = new Escultura(null,null,0,false,null,0,null,null,dim_escultura,null, null);

    sistema.addObras(escultura);
    
    escultura.exponer(exp1);

    Sorteo s = new SorteoFechaHora(20, LocalDate.of(2024, 4, 1), LocalDate.of(2024,4,15), LocalDate.of(2024, 4, 20), LocalTime.of(17,30));

    sistema.addSorteos(s);
    exp1.setSorteo(s);

    sistema.guardarDatos();

    try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.dat"))){
      out.writeObject(this);
    } catch(IOException e){
      e.printStackTrace();
    }
    boolean iguales = true;
    try (BufferedReader bf1 = new BufferedReader(new FileReader("fichero1.txt"))) {
      try (BufferedReader bf2 = new BufferedReader(new FileReader("fichero2.txt"))) {
        String str1 = bf1.readLine();
        String str2 = bf2.readLine();
        
        while ((str1!=null) && (str2!=null) && iguales) {
        
          if (!str1.equals(str2))
            iguales = false;
          
          str1 = bf1.readLine();
          str2 = bf2.readLine();
        }
      }
    }
    catch(IOException e){
      e.printStackTrace();
    }

    assert(iguales);
    
  } 

  @Test
  void testCargarDatos() {
    /*Mini sistema creado*/
    ClienteRegistrado c1 = new ClienteRegistrado("holamundo", "00000001A", false);
    sistema.addClientes(c1);

    Empleado e1 = new Empleado("empleado2024", "00000000C", "Calle la Retuerta", 567282342, 67313719, true, true, true);
    sistema.addEmpleados(e1);
    Entrada ent1 = new Entrada(1, 10.5, LocalDate.of(2024, 2, 24), LocalDate.of(2024, 3, 2), LocalTime.of(11, 30));
    sistema.addEntradas(ent1);
    Exposicion exp1 = new ExposicionPermanente("La cueva del oso", "Federico Martin", "Una exposicion llena de belleza", 10, EstadoExposicion.DISPONIBLE);

    sistema.addExposiciones(exp1);

    sistema.guardarDatos();
    
    Sistema s_aux = sistema;
    
    s_aux.cargarDatos();
    
    for(ClienteRegistrado c2: sistema.getClientes()){
      for(ClienteRegistrado c3: s_aux.getClientes()){
        assertEquals(c2.getPassword(), c3.getPassword());
        assertEquals(c2.getDni(), c3.getDni());
        assert(c2.isRecibirNotificaciones() == c3.isRecibirNotificaciones());
      }
      
    }
    
    for(Empleado e2: sistema.getEmpleados()){
      for(Empleado e3: s_aux.getEmpleados()){
         assertEquals(e2.getPassword(), e3.getPassword());
         assertEquals(e2.getDni(), e3.getDni());
         assertEquals(e2.getDireccion(), e3.getDireccion());
         assert(e2.getNss() == e3.getNss());
         assert(e2.getNumCuenta() == e3.getNumCuenta());
      }
    }

    for(Entrada ent2: sistema.getEntradas()){
      for(Entrada ent3: s_aux.getEntradas()){
        assert(ent2.getNumEntradas() == ent3.getNumEntradas());
        assert(ent2.getPrecioCompra() == ent3.getPrecioCompra());
        assertEquals(ent2.getNumTarjeta(), ent3.getNumTarjeta());
        assertEquals(ent2.getFechaCompra(), ent3.getFechaCompra());
        assertEquals(ent2.getFechaVisita(), ent3.getFechaVisita());
      }
    }
    
    for(Exposicion exp2: sistema.getExposiciones()) {
      for(Exposicion exp3: s_aux.getExposiciones()){
        assertEquals(exp2.getNombre(), exp3.getNombre());
        assert(exp2.getPrecio() == exp3.getPrecio());
        assertEquals(exp2.getDescr(), exp3.getDescr());
        assertEquals(exp2.getAutor(), exp3.getAutor());
        assertEquals(exp2.getEstado(), exp3.getEstado());
      }
    }
    
    
  } 
  @Test
  void testcargarObrasdeFichero(){
    Dimensiones dim_pintura = new Dimensiones(180, 180, 0);
    Temperatura t1 = new Temperatura(0, 20);
    Humedad h1 = new Humedad(40, 65);
    Pintura pintura = new Pintura("El beso", "Gustav Klimt", 1908, false, "SEG988976", 300000, "La obra representa dos amantes, y pertenece al periodo dorado de Klimt.", "Oleo sobre tela", dim_pintura, t1, h1);

    Dimensiones dim_escultura = new Dimensiones(17.1, 12.7, 19);
    Escultura escultura = new Escultura("For the love of God", "Damien Hirst", 2007, false, "SEG910076", 200000, "Molde de platino de una calavera humana incrustada con 8.601 diamantes.", "Diamante", dim_escultura, null, null);

    assertEquals(sistema.cargarObrasDeFichero("resources/testobras.csv"), Status.OK);

    for(Obra o: sistema.getObras()){
      if(o.getNombre().equals(pintura.getNombre())){
        assertEquals(o.getAutor(), pintura.getAutor());
        assert(o.isPropia() == pintura.isPropia());
        assert(o.getAnio() == pintura.getAnio());
        assertEquals(o.getDescr(), pintura.getDescr());
        assertEquals(o.getPoliza(), pintura.getPoliza());
        assert(o.getCuantia_seguro() == pintura.getCuantia_seguro());
      }
      else if(o.getNombre().equals(escultura.getNombre())){
        assertEquals(o.getAutor(), escultura.getAutor());
        assert(o.isPropia() == escultura.isPropia());
        assert(o.getAnio() == escultura.getAnio());
        assertEquals(o.getDescr(), escultura.getDescr());
        assertEquals(o.getPoliza(), escultura.getPoliza());
        assert(o.getCuantia_seguro() == escultura.getCuantia_seguro());
      }else{
        assert(false);
      }
    }
  }
  @Test
  void exposicionesDisponibles(){
    Exposicion exp1 = new ExposicionPermanente("La cueva del oso", "Federico Martin", "Una exposicion llena de belleza", 10, EstadoExposicion.DISPONIBLE);
    Exposicion exp2 = new ExposicionPermanente("La risa de las aves", "Francisco Lozoya", "Obras pintorescas y graciosas", 9, EstadoExposicion.INTERRUMPIDA);
    Exposicion exp3 = new ExposicionTemporal("El suspiro de la muerte", "Pablo Sanchez", "Dramatismo y horror", 12, EstadoExposicion.COMENZADA, LocalDate.of(2024, 3, 10), LocalDate.of(2024, 4, 10));

    Collection<Exposicion> disponibles = new ArrayList<Exposicion>();

    disponibles.add(exp1);
    disponibles.add(exp3);
    /*Exposicion exp4 = new ExposicionTemporal("Goya y sus caprichos", "Pedro Valentin", "Las obras menos conocidas de Goya", 12, EstadoExposicion.DISPONIBLE, LocalDate.of(2024, 4, 10), LocalDate.of(2024, 4, 28));*/
    sistema.addExposiciones(exp1, exp2, exp3);

    assertEquals(disponibles, sistema.exposicionesDisponibles());
  }


}
