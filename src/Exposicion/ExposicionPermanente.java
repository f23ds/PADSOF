package Exposicion;

import Entrada.*;
import Utils.Status;
import java.time.*;

/**
 * Clase para dar soporte a las exposiciones permanentes
 *
 * @author Fabio
 */
public class ExposicionPermanente extends Exposicion {

  LocalDate fInicioInterrupcion;
  LocalDate fFinInterrupcion;

  /**
   * Constructor de una exposición permanente
   * @param nombre
   * @param autor
   * @param descr
   * @param precio
   * @param estado
   */
  public ExposicionPermanente(
    String nombre,
    String autor,
    String descr,
    double precio,
    EstadoExposicion estado
  ) {
    super(nombre, autor, descr, precio, estado);
    fFinInterrupcion = null;
    fInicioInterrupcion = null;
  }

  /**
   * Método que indica si la exposición es permanente
   *
   * @return true si es permanente, false en caso contrario
   */
  @Override
  public boolean isPermanente() {
    return true;
  }

  /**
   * Método que indica si la exposición es temporal
   *
   * @return true si es temporal, false en caso contrario
   */
  @Override
  public boolean isTemporal() {
    return false;
  }

  @Override
  public LocalDate getfInicio() {
    return fInicioInterrupcion;
  }

  @Override
  public LocalDate getfFinal() {
    return fFinInterrupcion;
  }

  /**
   * Método para cambiar el estado de una exposición temporal a CANCELADA
   *
   * @return OK, ERROR en caso de cambio satisfactorio
   */
  public Status cancelar() {
    if (this.getEstado() != EstadoExposicion.EN_CREACION) return Status.ERROR;

    this.setEstado(EstadoExposicion.CANCELADA);

    return Status.OK;
  }

  /**
   * Método para interrumpir una exposición permanente
   * @param fInicio fecha de inicio de la interrupción
   * @param fFin fecha de fin de la interrupción
   * @return OK, ERROR según si se ha interrumpido satisfactoriamente o no
   */
  public Status interrumpir(LocalDate fInicio, LocalDate fFin) {
    for (Entrada e : this.getEntradas()) {
      LocalDate fechaVisita = e.getFechaVisita();

      if (fechaVisita.isAfter(fInicio) && fechaVisita.isBefore(fFin)) {
        return Status.ERROR;
      }
    }
    fInicioInterrupcion = fInicio;
    fFinInterrupcion = fFin;

    return Status.OK;
  }
}
