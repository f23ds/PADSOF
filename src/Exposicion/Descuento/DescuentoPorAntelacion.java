package Exposicion.Descuento;

import Usuario.ClienteRegistrado;
import java.time.LocalDate;
import java.time.Period;

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

  /**
   * Método que indica si el descuento es por antelación
   *
   * @return true si es por antelación, false en caso contrario
   */
  public boolean isPorAntelacion() {
    return true;
  }

  /**
   * Método que indica si el descuento es por compra
   *
   * @return true si es por compra, false en caso contrario
   */
  public boolean isPorCompra() {
    return false;
  }

  @Override
  /**
   * Método para verificar si el descuento por antelación es aplicable
   * @param fecha1 fecha a comparar con la fecha actual
   * @return true si el descuento es aplicable, false en caso contrario
   */
  public boolean checkDescuentoPorAntelacion(LocalDate fecha1) {
    LocalDate fecha2 = LocalDate.now();

    Period periodo = Period.between(fecha1, fecha2);

    // Obtener la diferencia de meses
    int diferenciaMeses = periodo.getMonths();

    return diferenciaMeses >= nMeses;
  }

  @Override
  /**
   * Método para verificar si el descuento por compra es aplicable
   * @param cliente cliente registrado que realiza la compra
   * @return false, ya que este descuento es específico para antelación
   */
  public boolean checkDescuentoPorCompra(ClienteRegistrado cliente) {
    return false;
  }
}
