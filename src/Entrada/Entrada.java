package Entrada;

import java.time.*;
import java.io.*;

/**
 * Clase para dar soporte a la entrada
 */
public class Entrada implements Serializable {

  private int numEntradas;
  private float precioCompra;
  private LocalDate fecha;
  private LocalTime hora;

  /**
   * Constructor de la clase entrada
   * @param numEntradas que se incluyen
   * @param precioCompra de las entradas
   * @param fecha de compra
   * @param hora de la exposición
   */
  public Entrada(
    int numEntradas,
    float precioCompra,
    LocalDate fecha,
    LocalTime hora
  ) {
    this.numEntradas = numEntradas;
    this.precioCompra = precioCompra;
    this.fecha = fecha;
    this.hora = hora;
  }

  /**
   * Getter del atributo numEntradas
   * @return numEntradas
   */
  public int getNumEntradas() {
    return numEntradas;
  }

  /**
   * Getter del atributo precioCompra
   * @return precioCompra
   */
  public float getPrecioCompra() {
    return precioCompra;
  }

  /**
   * Getter del atributo fecha
   * @return fecha
   */
  public LocalDate getFecha() {
    return fecha;
  }

  /**
   * Getter del atributo hora
   * @param hora
   */
  public LocalTime getHora() {
    return hora;
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
   * Setter del atributo fecha
   * @param fecha
   */
  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  /**
   * Setter del atributo hora
   * @param hora
   */
  public void setHora(LocalTime hora) {
    this.hora = hora;
  }
}
