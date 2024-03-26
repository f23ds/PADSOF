package Exposicion;

import Exposicion.Descuento.*;
import Sorteo.*;
import Utils.Status;
import java.util.*;

/**
 * Clase para dar soporte a las exposiciones permanentes
 *
 * @author Fabio Desio
 */
public class ExposicionPermanente extends Exposicion {

  /**
   * Constructor de una exposición permanente
   * @param nombre
   * @param autor
   * @param descr
   * @param estado
   * @param descuentos
   * @param sorteo
   * @param tiposObras
   */
  public ExposicionPermanente(
    String nombre,
    String autor,
    String descr,
    EstadoExposicion estado,
    ArrayList<Descuento> descuentos,
    Sorteo sorteo,
    ArrayList<TipoObraExposicion> tiposObras
  ) {
    super(nombre, autor, descr, estado, descuentos, sorteo, tiposObras);
  }

  /**
   * Método que indica si la exposición es permanente
   *
   * @return true si es permanente, false en caso contrario
   */
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

  /**
   * Método para cambiar el estado de una exposición temporal a CANCELADA
   *
   * @return OK, ERROR en caso de cambio satisfactorio
   */
  public Status cancelar() {
    if (this.getEstado() != EstadoExposicion.EN_CREACION) return Status.ERROR;

    /* FIXME: aquí habría que hacer algo con la semántica del método, así como marcar a TERMINADA en algún momento. */
    this.setEstado(EstadoExposicion.CANCELADA);

    return Status.OK;
  }

  /* TODO: interrumpir */
}
