package Exposicion;

import Exposicion.Descuento.Descuento;
import Sorteo.Sorteo;
import Utils.Status;
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

  /**
   * Método para cambiar el estado de una exposición temporal a COMENZADA
   *
   * @return OK, ERROR en caso de cambio satisfactorio
   */
  public Status comenzar() {
    if (this.getEstado() != EstadoExposicion.EN_CREACION) return Status.ERROR;

    /* Setteamos la exposición a COMENZADA, sabiendo que ha estado EN_CREACION */
    this.setEstado(EstadoExposicion.COMENZADA);

    return Status.OK;
  }

  /**
   * Método para prorrogar la fecha de una exposición temporal
   *
   * @return OK, ERROR en caso de prórroga satisfactoria
   */
  public Status prorrogar(LocalDate fecha) {
    if (this.getEstado() != EstadoExposicion.COMENZADA) return Status.ERROR;
    if (this.getfFinal().isAfter(fecha)) return Status.ERROR;

    /* Setteamos la fecha estipulada */
    this.setfFinal(fecha);

    return Status.OK;
  }

  /**
   * Método para cambiar el estado de una exposición temporal a CANCELADA
   *
   * @return OK, ERROR en caso de cambio satisfactorio
   */
  public Status cancelar() {
    if (this.getEstado() != EstadoExposicion.COMENZADA) return Status.ERROR;

    /* Setteamos la exposición a CANCELADA, sabiendo que ha sido COMENZADA */
    this.setEstado(EstadoExposicion.CANCELADA);

    /* Cambiamos su fecha de fin a dentro de una semana */
    /* TODO: quizá habría que hacer check con el horario, además de checkear la fecha de fin antes */
    this.setfFinal(LocalDate.now().plusWeeks(1));

    return Status.OK;
  }

  /**
   * Método para cambiar el estado de una exposición temporal a TERMINADA
   * Se entiende que se hace la comprobación de la fecha antes de llamar al método
   *
   * @return OK, ERROR en caso de cambio satisfactorio
   */
  public Status terminar() {
    if (
      this.getEstado() != EstadoExposicion.COMENZADA ||
      this.getEstado() != EstadoExposicion.CANCELADA
    ) return Status.ERROR;

    /* Setteamos la exposición a TERMINADA, sabiendo que ha sido COMENZADA o CANCELADA */
    this.setEstado(EstadoExposicion.TERMINADA);

    return Status.OK;
  }

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

  /**
   * Método que indica si la exposición es permanente
   *
   * @return true si es permanente, false en caso contrario
   */
  public boolean isPermanente() {
    return false;
  }

  /**
   * Método que indica si la exposición es temporal
   *
   * @return true si es temporal, false en caso contrario
   */
  public boolean isTemporal() {
    return true;
  }
}
