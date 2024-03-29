package Exposicion.Descuento;

import java.io.Serializable;

/**
 * Esta clase provee de soporte para los descuentos
 *
 * @author Fabio Desio
 */
public abstract class Descuento implements Serializable{

  private double descuento;

  /**
   * Constructor de la clase descuento
   * @param descuento
   */
  public Descuento(double descuento) {
    this.descuento = descuento;
  }

  /* GETTERS Y SETTERS */
  /**
   * Getter del atributo descuento
   * @return descuento
   */
  public double getDescuento() {
    return descuento;
  }

  /**
   * Setter del atributo descuento
   * @param descuento
   */
  public void setDescuento(double descuento) {
    this.descuento = descuento;
  }

  /**
   * Método abstracto para saber si el tipo de un descuento es por antelación
   * @return true, false según si es por antelación o no
   */
  public abstract boolean isPorAntelacion();

  /**
   * Método abstracto para saber si el tipo de un descuento es por compra
   * @return true, false según si es por compra o no
   */
  public abstract boolean isPorCompra();
}
