package Exposicion.Descuento;

/**
 * Esta clase provee de soporte para los descuentos
 *
 * @author Fabio Desio
 */
public abstract class Descuento {

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
}
