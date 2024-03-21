package Exposicion.Descuento;

/**
 * Esta clase da soporte a los descuentos por antelación
 * 
 * @author Fabio Desio
 */
public class DescuentoPorAntelacion extends Descuento {

  private int nMeses;

  /**
   * Constructor de la clase descuento por antelación
   * @param descuento estipulado
   * @param nMeses número de meses antelación
   */
  public DescuentoPorAntelacion(double descuento, int nMeses) {
    super(descuento);
    this.nMeses = nMeses;
  }

  /* GETTERS Y SETTERS */
  /**
   * Getter del atributo nMeses
   * @return nMeses
   */
  public int getNMeses() {
    return nMeses;
  }

  /**
   * Setter del atributo nMeses
   * @param nMeses 
   */
  public void setNMeses(int nMeses) {
    this.nMeses = nMeses;
  }
}
