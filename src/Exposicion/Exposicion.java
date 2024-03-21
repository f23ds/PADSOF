package Exposicion;

import Entrada.*;
import Exposicion.Descuento.*;
import Sorteo.*;
import Utils.*;
import java.time.*;
import java.util.*;

/**
 * Esta clase provee de soporte para la organización de exposiones
 *
 * @author Fabio Desio
 */
public abstract class Exposicion {

  private String nombre, autor, descr;
  private EstadoExposicion estado;
  private ArrayList<Descuento> descuentos;
  private Sorteo sorteo;
  private ArrayList<Entrada> entradas;
  private ArrayList<TipoObraExposicion> tiposObras;

  /**
   * Constructor para la clase abstracta Exposición
   * @param nombre de la exposición
   * @param autor de la exposición
   * @param descr de la exposición
   * @param estado de la exposición
   * @param descuentos de la exposición, únicamente dos y de tipos distintos
   * @param sorteo que se puede realizar en la exposición
   * @param entradas de la exposición
   * @param tiposObras de la exposición
   */
  public Exposicion(
    String nombre,
    String autor,
    String descr,
    EstadoExposicion estado,
    ArrayList<Descuento> descuentos,
    Sorteo sorteo,
    ArrayList<TipoObraExposicion> tiposObras
  ) {
    this.nombre = nombre;
    this.autor = autor;
    this.descr = descr;
    this.estado = estado;
    this.descuentos = new ArrayList<Descuento>();
    this.descuentos.add(null);
    this.descuentos.add(null);
    this.sorteo = sorteo;
    this.entradas = new ArrayList<Entrada>();
    this.tiposObras = new ArrayList<TipoObraExposicion>();
  }

  /**
   * Función privada para checkear si el array de descuentos ya está lleno
   * @return true en caso afirmativo, false en el otro caso
   */
  private boolean descuentosLlenos() {
    return this.descuentos.get(0) != null && this.descuentos.get(1) != null;
  }

  /**
   * Función para añadir un descuento al array de descuentos
   * @param desc descuento a añadir
   * @return OK, ERROR según si se ha realizado la inserción
   */
  public Status aniadirDescuento(Descuento desc) {
    boolean esPorCompra = desc instanceof DescuentoPorCompra ? true : false;

    /* Checkeamos que no esté lleno el array de descuentos */
    if (descuentosLlenos()) return Status.ERROR;

    /* Checkeamos que no haya descuentos del tipo especificado en el array */
    if (!esPorCompra && this.descuentos.get(0) != null) {
      return Status.ERROR;
    } else {
      this.descuentos.set(0, desc);
    }

    if (esPorCompra && this.descuentos.get(1) != null) {
      return Status.ERROR;
    } else {
      this.descuentos.set(1, desc);
    }

    return Status.OK;
  }

  /**
   * Función para quitar un descuento del array de descuentos
   * @param porCompra booleano que nos indica si queremos quitar el 
   * descuento por compra o por antelación.
   * @return OK, ERROR según si se ha quitado el descuento del array o no
   */
  public Status quitarDescuento(boolean porCompra) {
    int index = !porCompra ? 0 : 1;

    /* Setteamos en el array de descuentos el descuento correspondiente a null */
    this.descuentos.set(index, null);

    return Status.OK;
  }

  /**
   * Función para calcular el número de entradas totales que se han vendido 
   * para el periodo entre dos fechas en una exposición.
   * @param fInicio fecha de inicio
   * @param fFin fecha de fin
   * @return número total de entradas según condiciones
   */
  public int getNumEntradasTotal(LocalDate fInicio, LocalDate fFin) {
    int numEntradasTotal = 0;

    /* Iteramos por el array de entradas */
    for (Entrada entrada : this.entradas) {

      /* Comprobamos las condiciones */
      LocalDate fecha = entrada.getFecha();
      if (fecha.isBefore(fInicio) || fecha.isAfter(fFin)) continue;

      numEntradasTotal += entrada.getNumEntradas();
    }

    return numEntradasTotal;
  }

  /* TODO: TENER EN CUENTA POSIBLES DESCUENTOS */
  public double getDineroRecaudado(LocalDate fInicio, LocalDate fFin) {
    return 0.0;
  }

  /**
   * Función para calcular el número de entradas que se han vendido para una fecha 
   * y hora en específico.
   * @param fechaExp fecha a calcular
   * @param horaExp hora a calcular
   * @return número de entradas totales según condiciones
   */
  public int getEntradasPorHora(LocalDate fechaExp, LocalTime horaExp) {
    int numEntradasTotal = 0;

    /* Iteramos por el array de entradas */
    for (Entrada entrada : this.entradas) {
      LocalDate fecha = entrada.getFecha();
      LocalTime hora = entrada.getHora();

      /* Comprobamos las condiciones */
      if (!fecha.isEqual(fechaExp) || !hora.equals(horaExp)) continue;

      numEntradasTotal += entrada.getNumEntradas();
    }

    return numEntradasTotal;
  }

  /* GETTERS Y SETTERS */
  /**
   * Getter del atributo nombre
   * @return String con el nombre de la exposición
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Getter del atributo autor
   * @return String con el autor de la exposición
   */
  public String getAutor() {
    return autor;
  }

  /**
   * Getter del atributo descripción
   * @return String con la descripción de la exposición
   */
  public String getDescr() {
    return descr;
  }

  /**
   * Getter del atributo estado
   * @return Estadosxposicion con el estado de la exposición
   */
  public EstadoExposicion getEstado() {
    return estado;
  }

  /**
   * Getter del atributo descuentos
   * @return descuentos de la exposición
   */
  public ArrayList<Descuento> getDescuentos() {
    return descuentos;
  }

  /**
   * Getter del atributo sorteo
   * @return sorteo
   */
  public Sorteo getSorteo() {
    return sorteo;
  }

  /**
   * Getter del atributo entradas
   * @return entradas
   */
  public ArrayList<Entrada> getEntradas() {
    return entradas;
  }

  /**
   * Getter del atributo tiposObras
   * @return tiposObras
   */
  public ArrayList<TipoObraExposicion> getTiposObras() {
    return tiposObras;
  }

  /**
   * Setter del atributo nombre
   * @param nombre de la exposición
   */
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   * Setter del atributo autor
   * @param autor de la exposición
   */
  public void setAutor(String autor) {
    this.autor = autor;
  }

  /**
   * Setter del atributo descripción
   * @param descr de la exposición
   */
  public void setDescr(String descr) {
    this.descr = descr;
  }

  /**
   * Setter del atributo estado
   * @param estado de la exposición
   */
  public void setEstado(EstadoExposicion estado) {
    this.estado = estado;
  }

  /**
   * Setter del atributo descuentos
   * @param descuentos de la exposición
   */
  public void setDescuentos(ArrayList<Descuento> descuentos) {
    this.descuentos = descuentos;
  }

  /**
   * Setter del atributo sorteo
   * @param sorteo de la exposición
   */
  public void setSorteo(Sorteo sorteo) {
    this.sorteo = sorteo;
  }

  /**
   * Setter del atributo entradas
   * @param entradas de la exposición
   */
  public void setEntradas(ArrayList<Entrada> entradas) {
    this.entradas = entradas;
  }

  /**
   * Setter del atributo tiposObras
   * @param tiposObras la exposición
   */
  public void setTiposObras(ArrayList<TipoObraExposicion> tiposObras) {
    this.tiposObras = tiposObras;
  }
}
