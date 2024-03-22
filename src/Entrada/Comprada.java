package Entrada;

import Usuario.ClienteRegistrado;
import Utils.*;

import java.time.*;

/**
 * Clase para dar soporte a las entradas compradas
 *
 * @author Fabio Desio
 */
public class Comprada extends Entrada {

  private int numTarjeta;
  private ClienteRegistrado cliente;

  /**
   * Constructor de la clase entrada comprada
   * @param numEntradas a comprar
   * @param precioCompra total de la compra
   * @param fecha para la que se compra la entrada
   * @param hora para la que se compra la entrada
   * @param numTarjeta asociada a la compra
   * @param cliente comprador de la entrada
   */
  public Comprada(
    int numEntradas,
    float precioCompra,
    LocalDate fecha,
    LocalTime hora,
    int numTarjeta,
    ClienteRegistrado cliente
  ) {
    super(numEntradas, precioCompra, fecha, hora);
    this.numTarjeta = numTarjeta;
    this.cliente = cliente;
  }

  /* FIXME: de esto se encarga el TPV */
  public Status devolverDinero() {
    return Status.OK;
  }

  /* GETTERS Y SETTERS */
  /**
   * Getter del atributo numTarjeta
   * @return numTarjeta
   */
  public int getNumTarjeta() {
    return numTarjeta;
  }

  /**
   * Getter del atributo cliente registrado
   * @return cliente
   */
  public ClienteRegistrado getCliente() {
    return cliente;
  }

  /**
   * Setter del atributo numTarjeta
   * @param numTarjeta
   */
  public void setNumTarjeta(int numTarjeta) {
    this.numTarjeta = numTarjeta;
  }

  /**
   * Setter del atributo cliente registrado
   * @param cliente
   */
  public void setCliente(ClienteRegistrado cliente) {
    this.cliente = cliente;
  }
}
