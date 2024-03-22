package Exposicion;

import Exposicion.Descuento.Descuento;
import Sorteo.Sorteo;
import java.time.*;
import java.util.ArrayList;

/**
 * Clase para dar soporte a exposiciones temporales
 *
 * @author Fabio Desio
 */
public class ExposicionTemporal extends Exposicion {

  private LocalDate fInicio, fFinal;

  /**
   * Constructor de la exposición temporal
   * @param autor de la exposición temporal
   * @param nombre de la exposición temporal
   * @param descr de la exposición temporal
   * @param estado de la exposición temporal
   * @param descuentos de la exposición temporal
   * @param sorteo de la exposición temporal
   * @param tiposObras de la exposición temporal
   * @param fInicio de la exposición temporal
   * @param fFinal de la exposición temporal
   */
  public ExposicionTemporal(
    String nombre,
    String autor,
    String descr,
    EstadoExposicion estado,
    ArrayList<Descuento> descuentos,
    Sorteo sorteo,
    ArrayList<TipoObraExposicion> tiposObras,
    LocalDate fInicio,
    LocalDate fFinal
  ) {
    super(nombre, autor, descr, estado, descuentos, sorteo, tiposObras);
    this.fInicio = fInicio;
    this.fFinal = fFinal;
  }


  /* TODO: Métodos clase exposición temporal */

  /* GETTERS Y SETTERS */
  /**
   * Getter del atributo fecha de inicio
   * @return fInicio de la exposición temporal
   */
  public LocalDate getfInicio() {
    return fInicio;
  }

  /**
   * Getter del atributo fecha final
   * @return fFinal de la exposición temporal
   */
  public LocalDate getfFinal() {
    return fFinal;
  }

  /**
   * Setter del atributo fecha de inicio
   * @param fInicio de la exposición temporal
   */
  public void setfInicio(LocalDate fInicio) {
    this.fInicio = fInicio;
  }

  /**
   * Setter del atributo fecha final
   * @param fFinal de la exposición temporal
   */
  public void setfFinal(LocalDate fFinal) {
    this.fFinal = fFinal;
  }
}
