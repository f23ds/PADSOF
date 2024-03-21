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
}
