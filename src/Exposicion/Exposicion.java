package Exposicion;

import Entrada.*;
import Exposicion.Descuento.*;
import Obra.*;
import Sala.*;
import Sistema.*;
import Sorteo.*;
import Ticket.Ticket;
import Usuario.ClienteRegistrado;
import Utils.*;

import java.io.File;
import java.io.Serializable;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

import es.uam.eps.padsof.telecard.*;

import es.uam.eps.padsof.tickets.*;

/**
 * Esta clase provee de soporte para la organización de exposiones
 *
 * @author Fabio Desio
 */
public abstract class Exposicion implements Serializable {

  private String nombre, autor, descr;
  private double precio;
  private EstadoExposicion estado;
  private EstadoExposicion estadoSiguiente;
  private ArrayList<Descuento> descuentos;
  private Sorteo sorteo;
  private ArrayList<Entrada> entradas;
  private List<Sala> salas;
  private List<Obra> obras;

  /**
   * Constructor para la clase abstracta Exposición
   * 
   * @param nombre de la exposición
   * @param autor  de la exposición
   * @param descr  de la exposición
   * @param estado de la exposición
   * @param precio de la exposición
   * @param sorteo que se puede realizar en la exposición
   */
  public Exposicion(
      String nombre,
      String autor,
      String descr,
      double precio,
      EstadoExposicion estado) {
    this.nombre = nombre;
    this.autor = autor;
    this.descr = descr;
    this.precio = precio;
    this.estado = estado;
    this.sorteo = null;
    this.descuentos = new ArrayList<Descuento>();
    this.descuentos.add(null);
    this.descuentos.add(null);
    this.entradas = new ArrayList<Entrada>();
    this.precio = precio;
    this.obras = new ArrayList<Obra>();
    this.salas = new ArrayList<Sala>();
  }

  /**
   * getter del atributo salas
   *
   * @return salas de la exposicion
   */
  public List<Sala> getSalas() {
    return salas;
  }

  /**
   * getter del atributo precio
   *
   * @return precio entradas expo
   */
  public double getPrecio() {
    return precio;
  }

  /**
   * setter del atributo precio
   * 
   * @param precio entradas expo
   */
  public void setPrecio(double precio) {
    this.precio = precio;
  }

  /**
   * getter del atributo obras
   *
   * @return obras de la exposicion
   */
  public List<Obra> getObras() {
    return obras;
  }

  /**
   * comprueba si la exposicion tiene obras de un tipo especifico
   * 
   * @return true o false
   */
  public boolean tieneObraDeTipo(TipoDeObra tipo) {
    for (Obra obra : obras) {
      if (obra.getTipoObra() == tipo)
        return true;
    }

    return false;
  }

  /**
   * getter de la fecha de inicio de la exposicion
   * 
   * @return null
   */
  public LocalDate getfInicio() {
    return null;
  }

  /**
   * getter de la fecha de fin de la exposicion
   * 
   * @return null
   */
  public LocalDate getfFinal() {
    return null;
  }

  /**
   * Función privada para checkear si el array de descuentos ya está lleno
   *
   * @return true en caso afirmativo, false en el otro caso
   */
  private boolean descuentosLlenos() {
    return this.descuentos.get(0) != null && this.descuentos.get(1) != null;
  }

  /**
   * Función para añadir un descuento al array de descuentos
   *
   * @param desc descuento a añadir
   * @return OK, ERROR según si se ha realizado la inserción
   */
  public Status addDescuento(Descuento desc) {
    int index = desc.isPorCompra() ? 0 : 1;

    /* Checkeamos que no esté lleno el array de descuentos */
    if (descuentosLlenos())
      return Status.ERROR;

    /* Checkeamos que no haya descuentos del tipo especificado en el array */
    if (this.descuentos.get(index) != null)
      return Status.ERROR;

    this.descuentos.set(index, desc);

    return Status.OK;
  }

  /**
   * Función para quitar un descuento del array de descuentos
   *
   * @param porCompra booleano que nos indica si queremos quitar el
   *                  descuento por compra o por antelación.
   * @return OK, ERROR según si se ha quitado el descuento del array o no
   */
  public void quitarDescuento(boolean porCompra) {
    int index = !porCompra ? 0 : 1;

    /* Setteamos en el array de descuentos el descuento correspondiente a null */
    this.descuentos.set(index, null);
  }

  /**
   * Función para calcular el número de entradas totales que se han vendido
   * para el periodo entre dos fechas en una exposición.
   *
   * @param fInicio fecha de inicio
   * @param fFin    fecha de fin
   * @return número total de entradas según condiciones
   */
  public int getNumEntradasTotal(LocalDate fInicio, LocalDate fFin) {
    int numEntradasTotal = 0;

    /* Iteramos por el array de entradas */
    for (Entrada entrada : this.entradas) {
      /* Comprobamos las condiciones */
      LocalDate fecha = entrada.getFechaCompra();
      if (fecha.isBefore(fInicio) || fecha.isAfter(fFin))
        continue;

      numEntradasTotal += entrada.getNumEntradas();
    }

    return numEntradasTotal;
  }

  /*
   * TODO: TENER EN CUENTA POSIBLES DESCUENTOS (el precio pagado ya tiene en
   * cuenta descuentos)
   */
  public double getDineroRecaudado(LocalDate fInicio, LocalDate fFin) {
    double dinero = 0;

    /* Iteramos por el array de entradas */
    for (Entrada entrada : this.entradas) {
      /* Comprobamos las condiciones */
      LocalDate fecha = entrada.getFechaCompra();
      if (fecha.isBefore(fInicio) || fecha.isAfter(fFin))
        continue;
      dinero += entrada.getPrecioCompra();
    }

    return dinero;
  }

  /**
   * Comprar entrada con codigo de sorteo
   * 
   * @param cliente    cliente que compra
   * @param numEntrada numero de entradas que necesita
   * @param fecha      fecha de visita
   * @param hora       hora de visita
   * @param numTarjeta numero de tarjeta
   * @param codigo     codigo de sorteo
   * @return OK si la compra es valida, ERROR en caso contrario
   */
  public Status comprarEntrada(
      ClienteRegistrado cliente,
      int numEntrada,
      LocalDate fecha,
      LocalTime hora,
      String numTarjeta,
      String codigo) {
    UUID code = UUID.fromString(codigo);

    if (estado != EstadoExposicion.COMENZADA &&
        estado != EstadoExposicion.DISPONIBLE)
      return Status.ERROR;

    LocalDate fechaFinExp = this.getfFinal();

    if (isPermanente() && fechaFinExp != null) {
      // La expo esta interrumpida
      if (fecha.isAfter(this.getfInicio()) && fecha.isBefore(fechaFinExp))
        return Status.ERROR;
    } else if (isTemporal() && fecha.isAfter(fechaFinExp))
      return Status.ERROR;

    int aforo = 0;

    for (Sala sala : this.salas) {
      aforo += sala.getAforo();
    }

    int aforoOcupado = 0;

    for (Entrada entrada : this.entradas) {
      if (entrada.getHora().equals(hora) && entrada.getFechaVisita().isEqual(fecha))
        aforoOcupado++;
    }

    if (aforo - aforoOcupado < numEntrada)
      return Status.ERROR;

    double precio = this.precio * numEntrada;

    Comprada entrada = new Comprada(
        numEntrada,
        precio,
        LocalDate.now(),
        fecha,
        hora,
        numTarjeta,
        cliente);

    boolean valid = false;
    if (sorteo != null) {
      valid = sorteo.validarEntrada(entrada, code);
    }

    if (!valid) {
      return Status.ERROR;
    }
    /* Con sorteo la entrada es gratuita, no hace falta pagar */

    /* Generar ticket */
    try {
      TicketSystem.createTicket(
          new Ticket(entrada, 1, this, Sistema.getInstance().getIdEntradas()),
          "." + File.separator + "tmp" // Output folder
      );
    } catch (NonExistentFileException e) {
      return Status.ERROR;
    } catch (UnsupportedImageTypeException e) {
      return Status.ERROR;
    }

    entrada.setPrecioCompra(0.0);

    sorteo.getCodigos().remove(code);

    this.addEntradas(entrada);
    cliente.getEntradas().add(entrada);

    Sistema sist = Sistema.getInstance();

    sist.getEntradas().add(entrada);

    return Status.OK;
  }

  /**
   * Comprar entrada
   * 
   * @param cliente    cliente que compra
   * @param numEntrada numero de entradas que necesita
   * @param fecha      fecha de visita
   * @param hora       hora de visita
   * @param numTarjeta numero de tarjeta
   * @return OK si la compra es valida, ERROR en caso contrario
   */
  public Status comprarEntrada(
      ClienteRegistrado cliente,
      int numEntrada,
      LocalDate fecha,
      LocalTime hora,
      String numTarjeta) {
    if (estado != EstadoExposicion.COMENZADA &&
        estado != EstadoExposicion.DISPONIBLE)
      return Status.ERROR;

    LocalDate fechaFinExp = this.getfFinal();

    if (isPermanente() && fechaFinExp != null) {
      // La expo esta interrumpida
      if (fecha.isAfter(this.getfInicio()) && fecha.isBefore(fechaFinExp))
        return Status.ERROR;
    } else if (isTemporal() && fecha.isAfter(fechaFinExp))
      return Status.ERROR;

    int aforo = 0;
    for (Sala sala : this.salas) {
      aforo += sala.getAforo();
    }

    int aforoOcupado = 0;

    for (Entrada entrada : this.entradas) {
      if (entrada.getHora().equals(hora) && entrada.getFechaVisita().isEqual(fecha))
        aforoOcupado++;
    }

    if (aforo - aforoOcupado < numEntrada)
      return Status.ERROR;

    double desc = 0.0;

    Descuento d = descuentos.get(0);

    if (d != null) {
      if (d.checkDescuentoPorAntelacion(fecha))
        desc += d.getDescuento();
    }

    if (d != null) {
      if (d.checkDescuentoPorCompra(cliente))
        desc += d.getDescuento();
    }

    double precio = this.precio * numEntrada;

    Comprada entrada = new Comprada(
        numEntrada,
        precio,
        LocalDate.now(),
        fecha,
        hora,
        numTarjeta,
        cliente);

    /* Pagar entrada */
    if (!TeleChargeAndPaySystem.isValidCardNumber(numTarjeta))
      return Status.ERROR;

    try {
      TeleChargeAndPaySystem.charge(numTarjeta, "Entrada", precio, true);
    } catch (InvalidCardNumberException e) {
      return Status.ERROR;
    } catch (FailedInternetConnectionException e) {
      return Status.ERROR;
    } catch (OrderRejectedException e) {
      return Status.ERROR;
    }

    /* Generar ticket */
    try {
      TicketSystem.createTicket(
          new Ticket(entrada, desc, this, Sistema.getInstance().getIdEntradas()),
          "." + File.separator + "tmp" // Output folder
      );
    } catch (NonExistentFileException e) {
      return Status.ERROR;
    } catch (UnsupportedImageTypeException e) {
      return Status.ERROR;
    }

    precio *= (1 - desc);

    entrada.setPrecioCompra(precio);

    this.addEntradas(entrada);
    cliente.getEntradas().add(entrada);

    Sistema sist = Sistema.getInstance();

    sist.getEntradas().add(entrada);

    return Status.OK;
  }

  /**
   * Venta de entradas para el mismo dia
   * 
   * @param numEntrada numero de entradas a comprar
   * @param hora       hora de visita
   * @param numTarjeta numero de tarjeta
   * @return OK si la compra es valida, ERROR en caso contrario
   */
  public Status venderEntrada(int numEntrada, LocalTime hora, String numTarjeta) {
    if (estado != EstadoExposicion.COMENZADA &&
        estado != EstadoExposicion.DISPONIBLE)
      return Status.ERROR;

    int aforo = 0;
    for (Sala sala : this.salas) {
      aforo += sala.getAforo();
    }

    int aforoOcupado = 0;

    for (Entrada entrada : this.entradas) {
      if (entrada.getHora().equals(hora) && entrada.getFechaVisita().isEqual(LocalDate.now())) aforoOcupado++;
    }

    if (aforo - aforoOcupado < numEntrada) return Status.ERROR;

    LocalDate fecha = LocalDate.now();
    double precio = this.precio * numEntrada;

    Entrada entrada = new Entrada(numEntrada, precio, fecha, fecha, hora);

    /* Pagar entrada */
    if (!TeleChargeAndPaySystem.isValidCardNumber(numTarjeta))
      return Status.ERROR;

    try {
      TeleChargeAndPaySystem.charge(numTarjeta, "Entrada", precio, true);
    } catch (InvalidCardNumberException e) {
      return Status.ERROR;
    } catch (FailedInternetConnectionException e) {
      return Status.ERROR;
    } catch (OrderRejectedException e) {
      return Status.ERROR;
    }

    this.addEntradas(entrada);

    Sistema sist = Sistema.getInstance();

    sist.getEntradas().add(entrada);

    /* Generar ticket */
    try {
      TicketSystem.createTicket(
          new Ticket(entrada, 0.0, this, Sistema.getInstance().getIdEntradas()),
          "." + File.separator + "tmp" // Output folder
      );
    } catch (NonExistentFileException e) {
      return Status.ERROR;
    } catch (UnsupportedImageTypeException e) {
      return Status.ERROR;
    }

    return Status.OK;
  }

  /**
   * Función para calcular el número de entradas que se han vendido para una fecha
   * y hora en específico.
   * 
   * @param fechaExp fecha a calcular
   * @param horaExp  hora a calcular
   * @return número de entradas totales según condiciones
   */
  public int getEntradasPorHora(LocalDate fechaExp, LocalTime horaExp) {
    int numEntradasTotal = 0;

    /* Iteramos por el array de entradas */
    for (Entrada entrada : this.entradas) {
      LocalDate fecha = entrada.getFechaVisita();
      LocalTime hora = entrada.getHora();

      /* Comprobamos las condiciones */
      if (!fecha.isEqual(fechaExp) || !hora.equals(horaExp))
        continue;

      numEntradasTotal += entrada.getNumEntradas();
    }

    return numEntradasTotal;
  }

  /**
   * Método para cambiar el estado de la exposición de EN_CREACIÓN a DISPONIBLE
   *
   * @return OK, ERROR según si se ha cambiado el estado satisfactoriamente
   */
  public Status publicar() {
    if (this.estado != EstadoExposicion.EN_CREACION)
      return Status.ERROR;

    if (precio == 0.0)
      return Status.ERROR;

    /* Setteamos el estado de la exposición a DISPONIBLE */
    this.setEstado(EstadoExposicion.DISPONIBLE);

    return Status.OK;
  }

  /**
   * checkea el estado de las exposiciones y si debe cambiar
   */
  public Status checkEstadoExposicion() {
    LocalDate fecha1 = this.getfInicio();
    LocalDate fecha2 = this.getfFinal();

    if (fecha1 == null && fecha2 == null)
      return Status.ERROR;

    if (fecha1 != null) {
      if (fecha1.isEqual(LocalDate.now())) {
        if (this.isPermanente()) {
          estado = EstadoExposicion.INTERRUMPIDA;
        } else {
          estado = EstadoExposicion.COMENZADA;
        }
      }
    }

    if (fecha2 != null) {
      if (fecha2.isEqual(LocalDate.now())) {
        if (this.isPermanente()) {
          estado = EstadoExposicion.DISPONIBLE;
        } else {
          estado = estadoSiguiente;
        }
      }
    }

    return Status.OK;
  }

  /* -------------------- MÉTODOS ABSTRACTOS ---------------------- */
  /**
   * Método abstracto para saber si el tipo de una exposición es permanente
   * 
   * @return true, false según si es permanente o no
   */
  public abstract boolean isPermanente();

  /**
   * Método abstracto para saber si el tipo de una exposición es temporal
   * 
   * @return true, false según si es temporal o no
   */
  public abstract boolean isTemporal();

  /**
   * Método abstracto para cancelar una exposición según condicinoes
   * 
   * @return OK, ERROR según si se ha cancelado satisfactoriamente o no
   */
  public abstract Status cancelar();

  /* -------------------- GETTERS Y SETTERS ----------------------- */
  /**
   * Getter del atributo nombre
   * 
   * @return String con el nombre de la exposición
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Getter del atributo autor
   * 
   * @return String con el autor de la exposición
   */
  public String getAutor() {
    return autor;
  }

  /**
   * Getter del atributo descripción
   * 
   * @return String con la descripción de la exposición
   */
  public String getDescr() {
    return descr;
  }

  /**
   * Getter del atributo estado
   * 
   * @return Estadosxposicion con el estado de la exposición
   */
  public EstadoExposicion getEstado() {
    return estado;
  }

  /**
   * Getter del atributo descuentos
   * 
   * @return descuentos de la exposición
   */
  public ArrayList<Descuento> getDescuentos() {
    return descuentos;
  }

  /**
   * Getter del atributo sorteo
   * 
   * @return sorteo
   */
  public Sorteo getSorteo() {
    return sorteo;
  }

  /**
   * Getter del atributo entradas
   * 
   * @return entradas
   */
  public ArrayList<Entrada> getEntradas() {
    return entradas;
  }

  /**
   * Setter del atributo nombre
   * 
   * @param nombre de la exposición
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Setter del atributo autor
   * 
   * @param autor de la exposición
   */
  public void setAutor(String autor) {
    this.autor = autor;
  }

  /**
   * Setter del atributo estadoSiguiente
   * 
   * @param estadoSiguiente
   */
  public void setEstadoSiguiente(EstadoExposicion estadoSiguiente) {
    this.estadoSiguiente = estadoSiguiente;
  }

  /**
   * Setter del atributo descripción
   * 
   * @param descr de la exposición
   */
  public void setDescr(String descr) {
    this.descr = descr;
  }

  /**
   * Setter del atributo estado
   * 
   * @param estado de la exposición
   */
  public void setEstado(EstadoExposicion estado) {
    this.estado = estado;
  }

  /**
   * Setter del atributo descuentos
   * 
   * @param descuentos de la exposición
   */
  public void setDescuentos(ArrayList<Descuento> descuentos) {
    this.descuentos = descuentos;
  }

  /**
   * Setter del atributo sorteo
   * 
   * @param sorteo de la exposición
   */
  public void setSorteo(Sorteo sorteo) {
    this.sorteo = sorteo;
  }

  /**
   * Setter del atributo entradas
   * 
   * @param entradas de la exposición
   */
  public void setEntradas(ArrayList<Entrada> entradas) {
    this.entradas = entradas;
  }

  /*
   * --------------- MÉTODOS PARA AÑADIR O QUITAR ELEMENTOS DE ARRAYLISTS ------------------
   */
  /**
   * Método para añadir entradas al array de entradas
   * 
   * @param entradas a añadir
   */
  public void addEntradas(Entrada... entradas) {
    List<Entrada> entradasFilt = Arrays
        .stream(entradas)
        .filter(elemento -> elemento != null)
        .collect(Collectors.toList());

    this.entradas.addAll(entradasFilt);
  }

  /**
   * añade salas en las que se realiza la exposicion
   *
   * @param salas a añadir
   */
  public void addSalas(Sala... salas) {
    List<Sala> salasFilt = Arrays
        .stream(salas)
        .filter(elemento -> elemento != null)
        .collect(Collectors.toList());

    for (Sala sala : salasFilt) {
      sala.setExpo(this);
    }

    this.salas.addAll(salasFilt);
  }

  /**
   * añade obras a la exposicion
   *
   * @param obras a añadir
   */
  public void addObras(Obra... obras) {
    List<Obra> obrasFilt = Arrays
        .stream(obras)
        .filter(elemento -> elemento != null)
        .collect(Collectors.toList());

    this.obras.addAll(obrasFilt);
  }

  /**
   * quita obras de la exposicion
   *
   * @param obras a quitar
   */
  public void removeObras(Obra... obras) {
    this.obras.removeAll(Arrays.asList(obras));
  }
}
