package Entrada;

import java.time.LocalDateTime;

/**
 * Clase para dar soporte a la entrada
 */
public class Entrada {

  private int numEntradas;
  private float precioCompra;
  private LocalDateTime fechaHora;

  /**
   * Constructor de la clase entrada
   * @param numEntradas que se incluyen
   * @param precioCompra de las entradas
   * @param fechaHora de la expedición de la entrada
   */
  public Entrada(int numEntradas, float precioCompra, LocalDateTime fechaHora) {
    this.numEntradas = numEntradas;
    this.precioCompra = precioCompra;
    this.fechaHora = fechaHora;
  }

  /**
   * Getter del atributo 
   * @return
   */
  public int getNumEntradas() {
    return numEntradas;
  }

  /**
   * Getter del atributo 
   * @return
   */
  public float getPrecioCompra() {
    return precioCompra;
  }

  /**
   * Getter del atributo 
   * @return
   */
  public LocalDateTime getFechaHora() {
    return fechaHora;
  }

  /**
   * Setter del atributo numEntradas
   * @param numEntradas
   */
  public void setNumEntradas(int numEntradas) {
    this.numEntradas = numEntradas;
  }

  /**
   * Setter del atributo precioCompra 
   * @param precioCompra
   */
  public void setPrecioCompra(float precioCompra) {
    this.precioCompra = precioCompra;
  }

  /**
   * Setter del atributo fechaHora
   * @param fechaHora
   */
  public void setFechaHora(LocalDateTime fechaHora) {
    this.fechaHora = fechaHora;
  }
}
