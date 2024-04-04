package Sistema;

import Entrada.*;
import Exposicion.*;
import Horario.*;
import Obra.*;
import Sala.*;
import Sorteo.*;
import Usuario.*;
import Utils.*;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Esta clase define el sistema que controla desde arriba todo el centro de
 * exposiciones
 *
 * @author Victor Sanz de Vergas
 *
 */
public class Sistema implements Serializable {

  private int idEntradas = 0;/*Id que se asignará a cada entrada */
  private static Sistema instance;/* Singleton de la clase Sistema */
  private Collection<Entrada> entradas;/* Coleccion con las entradas vendidas por el centro */
  private Horario horario;/* Horario de apertura y cierre del centro */
  private Collection<ClienteRegistrado> clientes;/* Coleccion con los clientes registrados */
  private Collection<Empleado> empleados;/* Colleccion con los empleados registrados */
  private Gestor gestor;/* Referencia al gestor del centro */
  private Usuario usuarioActivo;/* Referencia al usuario activo en el sistema en el momento */
  private Collection<Obra> obras;/* Obras disponibles en el centro de exposiciones */
  private Collection<Sala> salas;/* Coleccion de salas en el centro de exposiciones */
  private Collection<Sorteo> sorteos;/* Sorteos disponibles para las exposiciones del centro */
  private Collection<Exposicion> exposiciones;/* Exposiciones en el centro en ese momento */

  /**
   * GetInstance necesario para el Singleton que devuelve el atributo estatico
   * Sistema
   *
   * @param horario       horario del centro
   * @param gestor        gestor del centro
   * @return instancia del atributo estatico Sistema
   */
  public static Sistema getInstance(
  ) {
    if (instance == null) {
      instance = new Sistema();
    }
    return instance;
  }

  /**
   * Simulador de apagar la aplicacion
   */
  public static void setInstanceNull(){
    instance = null;
  }

  /**
   * Constructo privado sin argumentos que unicamente crea Sistema
   */
  private Sistema() {
    this.horario = new Horario(9,30,20,0);
    this.gestor = new Gestor("Password123", "JefeAlberto");
    this.entradas = new ArrayList<Entrada>();
    this.clientes = new ArrayList<ClienteRegistrado>();
    this.empleados = new ArrayList<Empleado>();
    this.obras = new ArrayList<Obra>();
    this.salas = new ArrayList<Sala>();
    this.sorteos = new ArrayList<Sorteo>();
    this.exposiciones = new ArrayList<Exposicion>();
  }

  /**
   * getter del atributo idEntradas, que se incrementa cada vez
   * que se genera una entrada
   * 
   * @return id a asignar a la entrada
   */
  public int getIdEntradas() {
    idEntradas++;
    return idEntradas;
  }

  /**
   * Añadir entradas a la lista de entradas vendidas
   *
   * @param entradas array de entradas para añadir
   */
  public void addEntradas(Entrada... entradas) {
    for (Entrada e : entradas) {
      this.entradas.add(e);
    }
  }

  /**
   * Añadir clientes a la lista de clientes registrados
   *
   * @param clientes array con los clientes a añadir
   */
  public void addClientes(ClienteRegistrado... clientes) {
    for (ClienteRegistrado c : clientes) {
      this.clientes.add(c);
    }
  }

  /**
   * Añadir empleados a la coleccion de empleados
   *
   * @param empleados array con los empleados a añadir
   */
  public void addEmpleados(Empleado... empleados) {
    for (Empleado e : empleados) {
      this.empleados.add(e);
    }
  }

  /**
   * Añadir obras a la coleccion de obraa
   *
   * @param obras array con las obras a añadir
   */
  public void addObras(Obra... obras) {
    for (Obra o : obras) {
      this.obras.add(o);
    }
  }

  /**
   * Añadir salas a la coleccion de salas del centro
   *
   * @param salas array con las salas a añadir
   */
  public void addSalas(Sala... salas) {
    for (Sala s : salas) {
      this.salas.add(s);
    }
  }

  /**
   * Añadir sorteos a la coleccion de sorteos activos
   *
   * @param sorteos array con sorteos a añadir
   */
  public void addSorteos(Sorteo... sorteos) {
    for (Sorteo s : sorteos) {
      this.sorteos.add(s);
    }
  }

  /**
   * Añadir exposiciones a la coleccion de exposiciones
   *
   * @param exposiciones array con las exposiciones a añadir
   */
  public void addExposiciones(Exposicion... exposiciones) {
    for (Exposicion e : exposiciones) {
      this.exposiciones.add(e);
    }
  }

  /**
   * Setter del horario del centro de exposiciones
   *
   * @param horario horario del centro
   */
  public void setHorario(Horario horario) {
    this.horario = horario;
  }

  /**
   * Setter del gestor del centro de exposiciones
   *
   * @param gestor objeto referente al gestor del centro
   */
  public void setGestor(Gestor gestor) {
    this.gestor = gestor;
  }

  /**
   * Setter del usuario activo en ese momento
   *
   * @param usuarioActivo objeto referente al usuario activo
   */
  public void setUsuarioActivo(Usuario usuarioActivo) {
    this.usuarioActivo = usuarioActivo;
  }

  /**
   * Getter del horario del centro
   *
   * @return objeto referente al horario
   */
  public Horario getHorario() {
    return horario;
  }

  /**
   * Getter de la coleccion de clientes registrados
   *
   * @return coleccion de clientes
   */
  public Collection<ClienteRegistrado> getClientes() {
    return clientes;
  }

  /**
   * Getter de la coleccion de empleados registrados
   *
   * @return coleccion de empleados
   */
  public Collection<Empleado> getEmpleados() {
    return empleados;
  }

  /**
   * Getter de la coleccion de empleados
   *
   * @return objeto referente al gestor del centro
   */
  public Gestor getGestor() {
    return gestor;
  }

  /**
   * Getter del usuario activo en ese momento
   *
   * @return objeto referente al usuario activo
   */
  public Usuario getUsuarioActivo() {
    return usuarioActivo;
  }

  /**
   * Getter de la coleccion de obras del centro
   *
   * @return coleccion con las obras
   */
  public Collection<Obra> getObras() {
    return obras;
  }

  /**
   * Getter de la coleccion de salas del centro
   *
   * @return coleccion con las salas
   */
  public Collection<Sala> getSalas() {
    return salas;
  }

  /**
   * Getter de la coleccion de los sorteos disponibles en el centro
   *
   * @return coleccion con los sorteos
   */
  public Collection<Sorteo> getSorteos() {
    return sorteos;
  }

  /**
   * Getter de la coleccion de exposiciones en el centro
   *
   * @return coleccion con las exposiciones
   */
  public Collection<Exposicion> getExposiciones() {
    return exposiciones;
  }

  /**
   * Getter de la coleccion de entradas vendidas en el centro
   *
   * @return coleccion con las entradas
   */
  public Collection<Entrada> getEntradas() {
    return entradas;
  }

  /**
   * Login del cliente buscandolo en la coleccion de clientes del sistema
   *
   * @param dni string con el dni del cliente a logear
   * @param pwd contraseña del cliente a logear
   * @return objeto referente al cliente encontrado o null si no se encuentra
   */
  public ClienteRegistrado loginCliente(String dni, String pwd) {

    for (ClienteRegistrado c : clientes) {
      if (dni.equals(c.getDni()) && pwd.equals(c.getPassword())) {
        return c;
      }
    }
    return null;
  }

  /**
   * Login del empleado buscandolo en la coleccion de empleados del sistema
   *
   * @param dni string con el dni del empleado a logear
   * @param password contraseña del empleado a logear
   * @return objeto referente al empleado encontrado o null si no se encuentra
   */
  public Empleado loginEmpleado(String dni, String password) {

    for (Empleado e : empleados) {
      if (dni.equals(e.getDni()) && password.equals(e.getPassword())) {
        return e;
      }
    }
    return null;
  }

  /**
   * Login del gestor comprobando sus credenciales
   *
   * @param usuario string con el dni del gestor a logear
   * @param password contraseña del gestor a logear
   * @return objeto referente al gestor o null si las credenciales no son
   *         correctas
   */
  public Gestor loginGestor(String usuario, String password) {

    if (
      usuario.equals(gestor.getUsuario()) &&
      password.equals(gestor.getPassword())
    ) {
      return gestor;
    }
    return null;
  }

  /**
   * cerrar sesion
   * @return
   */
  public void cerrarSesion() {
    usuarioActivo = null;
    this.guardarDatos();
  }

  /**
   * Buscar las exposiciones permanentes en el centro de exposiciones
   *
   * @return arraylist con las exposiciones permanenetes
   */
  public Collection<Exposicion> buscarPorPermanente() {
    Collection<Exposicion> permanentes = new ArrayList<Exposicion>();

    for (Exposicion e : exposiciones) {
      if (e.isPermanente()) {
        permanentes.add(e);
      }
    }

    return permanentes;
  }

  /**
   * Buscar las exposiciones temporales en el centro de exposiciones
   *
   * @return arraylist con las exposiciones temporales
   */
  public Collection<Exposicion> buscarPorTemporal() {
    Collection<Exposicion> temporales = new ArrayList<>();

    for (Exposicion e : exposiciones) {
      if (e.isTemporal()) {
        temporales.add(e);
      }
    }

    return temporales;
  }

  /**
   * devuelve las exposiciones con obras de tipos especificos
   *
   * @param tipos tipos de obras que deben tener
   * @return exposiciones validas
   */
  public List<Exposicion> buscarPorTipo(TipoDeObra... tipos) {
    List<Exposicion> exp_validas = new ArrayList<Exposicion>();

    boolean valid = true;

    for (Exposicion e : exposiciones) {
      valid = true;
      for (TipoDeObra t : tipos) {
        if (e.tieneObraDeTipo(t)) {
          continue;
        } else {
          valid = false;
          break;
        }
      }
      if (valid) exp_validas.add(e);
    }

    return exp_validas;
  }

  /**
   * buscar exposiciones disponibles entre dos fechas
   *
   * @param inicio fecha inicial
   * @param fin    fecha final
   * @return exposiciones disponibles
   */
  public List<Exposicion> buscarPorFecha(LocalDate inicio, LocalDate fin) {
    List<Exposicion> exp_validas = new ArrayList<Exposicion>();

    for (Exposicion e : exposiciones) {
      if (e.isPermanente() && e.getEstado() == EstadoExposicion.DISPONIBLE) {
        exp_validas.add(e);
      } else if (e.isTemporal()) {
        if (
          e.getfInicio().isBefore(inicio) &&
          e.getfFinal().isAfter(fin) &&
          (
            e.getEstado() == EstadoExposicion.DISPONIBLE ||
            e.getEstado() == EstadoExposicion.COMENZADA
          )
        ) exp_validas.add(e);
      }
    }

    return exp_validas;
  }

  /**
   * Calcula las entradas totales vendidas en el centro entre dos fechas
   * @param inicio fecha inicial
   * @param fin fecha final
   * @return numero total de entradas
   */
  public int getNumEntradasTotales(LocalDate inicio, LocalDate fin) {
    int numEntradasTotal = 0;

    /* Iteramos por el array de entradas */
    for (Entrada entrada : this.entradas) {
      /* Comprobamos las condiciones */
      LocalDate fecha = entrada.getFechaCompra();
      if (fecha.isBefore(inicio) || fecha.isAfter(fin)) continue;

      numEntradasTotal += entrada.getNumEntradas();
    }

    return numEntradasTotal;
  }

  /**
   * Calcula el dinero recaudado en el centro entre dos fechas
   * @param inicio fecha inicial
   * @param fin fecha final
   * @return numero total de entradas
   */
  public double getDineroRecaudadoTotal(LocalDate inicio, LocalDate fin) {
    double dinero = 0;

    /* Iteramos por el array de entradas */
    for (Entrada entrada : this.entradas) {
      /* Comprobamos las condiciones */
      LocalDate fecha = entrada.getFechaCompra();
      if (fecha.isBefore(inicio) || fecha.isAfter(fin)) continue;

      dinero += entrada.getPrecioCompra();
    }

    return dinero;
  }

  /**
   * Envia notificaciones desde el sistema a todos los clientes
   *
   * @param notificacion notificacion a enviar
   */
  public void enviarNotificacionSist(Notificacion notificacion) {
    for (ClienteRegistrado c : clientes) {
      if (c.isRecibirNotificaciones()) c.addNotificaciones(notificacion);
    }
  }

  /**
   * Enviar notificaciones a todos los clientes desde un empleado
   *
   * @param notificacion notificacion a enviar
   * @param empleado empleado que envia la notificacion
   * @return OK o ERROR dependiendo de si ha salido bien o no
   */
  public Status enviarNotificacionEmp(
    Notificacion notificacion,
    Empleado empleado
  ) {
    if (!empleado.isEnviarNotificaciones()) {
      return Status.ERROR;
    }

    for (ClienteRegistrado c : clientes) {
      if (c.isRecibirNotificaciones()) {
        c.addNotificaciones(notificacion);
      }
    }

    return Status.OK;
  }

  /**
   * Guardar los datos cargados en el sistema
   */
  public void guardarDatos() {
    try (
      ObjectOutputStream out = new ObjectOutputStream(
        new FileOutputStream("sistema.dat")
      )
    ) {
      out.writeObject(this);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Cargar los datos del sistema si existen previos
   */
  public void cargarDatos() {
    File file = new File("sistema.dat");

    // Verificar si el archivo existe
    if (!file.exists()) return;

    try (
      ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("sistema.dat")
      )
    ) {
      Sistema otro = (Sistema) in.readObject();
      copiarSistema(otro);
      for (Exposicion e : exposiciones) {
        e.checkEstadoExposicion();
      }
      instance = this;
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * metodo para copiar un sistema en otro
   *
   * @param otro sistema a copiar
   */
  private void copiarSistema(Sistema otro) {
    // Copiando los atributos
    entradas = new ArrayList<>(otro.entradas);
    horario = otro.horario;
    clientes = new ArrayList<>(otro.clientes);
    empleados = new ArrayList<>(otro.empleados);
    gestor = otro.gestor; // Referencia al mismo objeto Gestor
    usuarioActivo = otro.usuarioActivo; // Referencia al mismo objeto Usuario
    obras = new ArrayList<>(otro.obras);
    salas = new ArrayList<>(otro.salas);
    sorteos = new ArrayList<>(otro.sorteos);
    exposiciones = new ArrayList<>(otro.exposiciones);
  }

  /**
   * lee las obras de un fichero y las añade
   *
   * @param fichero nombre del fichero con las obras
   * @return OK o ERROR
   */
  public Status cargarObrasDeFichero(String fichero) {
    String linea = "";
    String separador = ";";

    try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
      while ((linea = br.readLine()) != null) {
        // Dividir la línea en campos usando el separador ","
        String[] campos = linea.split(separador, -1);

        Obra obra = null;
        if (campos[0].equals("CUADRO")) {
          obra = Pintura.cargarPinturaDeFichero(campos);
        } else if (campos[0].equals("ESCULTURA")) {
          obra = Escultura.cargarEsculturaDeFichero(campos);
        } else if (campos[0].equals("FOTOGRAFIA")) {
          obra = Fotografia.cargarFotografiaDeFichero(campos);
        } else if (campos[0].equals("AUDIOVISUAL")) {
          obra = Audiovisual.cargarAudiovisualDeFichero(campos);
        } else {
          continue;
        }

        if (!this.obras.contains(obra)) this.obras.add(obra);
      }
    } catch (IOException e) {
      e.printStackTrace();

      return Status.ERROR;
    }

    return Status.OK;
  }

  /**
   * Método para saber cuales son las exposiciones disponibles en el centro
   *
   * @return coleccion con las exposiciones disponibles
   */
  public Collection<Exposicion> exposicionesDisponibles() {
    Collection<Exposicion> disponibles = new ArrayList<Exposicion>();
    for (Exposicion e : exposiciones) {
      if (
        e.getEstado() == EstadoExposicion.DISPONIBLE ||
        e.getEstado() == EstadoExposicion.COMENZADA
      ) {
        disponibles.add(e);
      }
    }

    return disponibles;
  }
}
