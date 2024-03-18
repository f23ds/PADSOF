package Exposicion;

import java.time.*;

/**
 * Clase para dar soporte a exposiciones temporales
 *
 * @author Fabio Desio
 */
public class ExposicionTemporal extends Exposicion {

  private LocalDate fInicio, fFinal;

  /**
   * Constructor de las exposiciones temporales
   * @param nombre de la exposición temporal
   * @param autor de la exposición temporal
   * @param descr de la exposición temporal
   * @param estado de la exposición temporal
   * @param fInicio de la exposición temporal
   * @param fFinal de la exposición temporal
   */
  public ExposicionTemporal(
    String nombre,
    String autor,
    String descr,
    EstadoExposicion estado,
    LocalDate fInicio,
    LocalDate fFinal
  ) {
    super(nombre, autor, descr, estado);
    this.fInicio = fInicio;
    this.fFinal = fFinal;
  }

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
