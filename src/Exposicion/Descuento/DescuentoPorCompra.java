package Exposicion.Descuento;

/**
 * Esta clase da soporte a los descuentos por antelación
 *
 * @author Fabio Desio
 */
public class DescuentoPorCompra extends Descuento {

  private int nEntradas;

  /**
   * Constructor de la clase descuento por antelación
   * @param descuento estipulado
   * @param nEntradas número de meses antelación
   */
  public DescuentoPorCompra(double descuento, int nEntradas) {
    super(descuento);
    this.nEntradas = nEntradas;
  }

  /* GETTERS Y SETTERS */
  /**
   * Getter del atributo nEntradas
   * @return nEntradas
   */
  public int getNEntradas() {
    return nEntradas;
  }

  /**
   * Setter del atributo nEntradas
   * @param nEntradas
   */
  public void setNEntradas(int nEntradas) {
    this.nEntradas = nEntradas;
  }

  /**
   * Método que indica si el descuento es por antelación
   *
   * @return true si es por antelación, false en caso contrario
   */
  public boolean isPorAntelacion() {
    return false;
  }

  /**
   * Método que indica si el descuento es por compra
   *
   * @return true si es por compra, false en caso contrario
   */
  public boolean isPorCompra() {
    return true;
  }
}
